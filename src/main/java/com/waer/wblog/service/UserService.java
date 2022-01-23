package com.waer.wblog.service;


import com.waer.wblog.entity.User;

import java.util.Map;

/**
 * @Description: 用户业务层接口
 * @Author: ONESTAR
 * @Date: Created in 10:59 2020/3/26
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface UserService {

    /**
     * 核对用户名和密码
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User checkUser(String username, String password);

}