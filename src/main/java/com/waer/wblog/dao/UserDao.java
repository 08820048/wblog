package com.waer.wblog.dao;


import com.waer.wblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User selectById(int id);

    User selectByName(String nickname);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateType(int id);

    int updateHeader(int id,String headerUrl);

    int updatePassword(String email,String password);
}