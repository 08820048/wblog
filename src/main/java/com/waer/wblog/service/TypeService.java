package com.waer.wblog.service;

import com.waer.wblog.entity.Type;

import java.util.List;


/**
 * @Description: 文章分类业务层接口
 * @Author: ONESTAR
 * @Date: Created in 14:32 2020/3/27
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type>getAllType();

    List<Type>getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);




}