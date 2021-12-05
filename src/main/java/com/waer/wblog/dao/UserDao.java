package com.waer.wblog.dao;


import com.waer.wblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 照片墙持久层接口
 * @Date: Created in 23:32 2020/4/16
 * @Author: WAer
 */
@Mapper
@Repository
public interface UserDao {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}