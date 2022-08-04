package com.waer.wblog;

import com.waer.wblog.entity.Blog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author: XuYi
 * @date: 2021/11/22 18:05
 * @description: 发送邮件测试
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = WblogApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testText(){
        mailClient.sendMail("2217021563@qq.com","test","ComunityProjects");
    }


    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");
        String content = templateEngine.process("/demo", context);
        System.out.println(content);
        mailClient.sendMail("2217021563@qq.com", "HTML", content);
    }

    @Test
    public void sendTemplateMail(){
            Blog blog = new Blog();
            /*发送邮件*/
            Context context = new Context();
            context.setVariable("sendEmail", blog);
            String content = templateEngine.process("/demo", context);
            System.out.println(content);
            mailClient.sendMail("2217021563@qq.com", "HTML", content);
    }
}
