package com.waer.wblog.service.Impl;
import com.waer.wblog.NotFoundException;
import com.waer.wblog.dao.BlogDao;
import com.waer.wblog.entity.Blog;
import com.waer.wblog.queryvo.*;
import com.waer.wblog.service.BlogService;
import com.waer.wblog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlogQuery();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.searchByTitleOrTypeOrRecommend(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = blogDao.getAllRecommendBlog();
        return allRecommendBlog;
    }

//    @Override
//    public List<FirstPageBlog> getNewBlog() {
//        return blogDao.getNewBlog();
//    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        System.out.println(id);
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
//        文章访问数量自增
        blogDao.updateViews(id);
//        文章评论数量更新
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }


    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }

    @Override
    public int updatePublish(Long id) {
        return blogDao.updatePushed(id);
    }

    @Override
    public int updatePush(Long id) {
        return blogDao.updatePush(id);
    }

    @Override
    public int updatePrivated(Long id) {
        return blogDao.updatePrivated(id);
    }

    @Override
    public int updatePrivate(Long id) {
        return blogDao.updatePrivate(id);
    }

    @Override
    public Blog selectTopwdById(Long id) {
        Blog blog = blogDao.gettoPwd(id);
        if(Objects.isNull(blog)){
            throw new NotFoundException("该博客不存在");
        }
        return blog;
    }
}