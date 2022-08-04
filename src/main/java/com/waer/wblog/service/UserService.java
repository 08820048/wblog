package com.waer.wblog.service;


import com.waer.wblog.entity.User;

import java.util.Map;


public interface UserService {

    /**
     * 核对用户名和密码
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User checkUser(String username, String password);

}