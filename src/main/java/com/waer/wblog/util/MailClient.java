package com.waer.wblog.util;

import com.waer.wblog.dao.CommentDao;
import com.waer.wblog.dao.MessageDao;
import com.waer.wblog.entity.Blog;
import com.waer.wblog.entity.Comment;
import com.waer.wblog.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;


/**
 * @author: XuYi
 * @date: 2021/11/22 17:54
 * @description: 封装邮件发送工具客户端
 */
@Component
public class MailClient {
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private CommentDao commentDao;
    @Value("${spring.mail.username}")
    private String from;
    public void sendMail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.error("发送邮件失败:" + e.getMessage());
        }
        logger.info("邮件发送成功");
    }

    /**
     * 发送回复邮件
     * @param message msg
     */
    public void sendTemplateMail(Message message, Blog blog, Comment comment){
        if(!comment.isAdminComment() && comment.getParentCommentId()!=-1&& message.getParentMessageId()!=-1){
            comment.setNickname(message.getNickname());
            comment.setReplyComments(comment.getReplyComments());
            comment.setEmail(message.getEmail());
            /*发送邮件*/
            Context context = new Context();
            context.setVariable("sendEmail", comment);
            String content = templateEngine.process("/emailTemplate-message", context);
            System.out.println(content);
            sendMail("2217021563@qq.com", "HTML", content);
        }
    }
}
