package com.waer.wblog.service.Impl;
import com.waer.wblog.dao.BlogDao;
import com.waer.wblog.dao.CommentDao;
import com.waer.wblog.entity.Comment;
import com.waer.wblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogDao blogDao;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //查询出父节点
        List<Comment> comments = commentDao.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentDao.findByBlogIdParentIdNotNull(blogId,id);
//            查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
//        判断是否有一级子评论
        if(childComments.size() > 0){
//                循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
//                    查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    private void recursively(Long blogId, Long childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }

//    新增评论
    @Override
    public int saveComment(Comment comment) {
        int comments = 0;
        comment.setCreateTime(new Date());
        if(comment.getNickname()== null || comment.getNickname().equals("") || comment.getNickname().length() >=8){
            log.error("评论人昵称不能为空或者长度不能超过8");
            System.out.println("评论人昵称不能为空或者长度不能超过8");
        }else if(comment.getContent() == null || comment.getContent().equals("") || comment.getContent().length() >=15) {
            log.error("评论内容不能为空或者长度不能超过15");
            System.out.println("评论内容不能为空或者长度不能超过15");
        }else {
             comments = commentDao.saveComment(comment);
            blogDao.getCommentCountById(comment.getBlogId());
        }
        return comments;
    }

//    删除评论
    @Override
    public void deleteComment(Comment comment,Long id) {
        commentDao.deleteComment(id);
        blogDao.getCommentCountById(comment.getBlogId());
    }
}