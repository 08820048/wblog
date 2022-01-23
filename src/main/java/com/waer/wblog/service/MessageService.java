package com.waer.wblog.service;



import com.waer.wblog.entity.Message;

import java.util.List;

/**
 * @Description: 留言业务层接口
 * @Date: Created in 11:23 2020/4/16
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface MessageService {

    /**
     * 查询留言列表
     * @return list
     */
    List<Message> listMessage();

    /**
     * 保存留言
     * @param message msg
     * @return int
     */
    int saveMessage(Message message);

    /**
     * 删除留言
     * @param id
     */
    void deleteMessage(Long id);

    /**
     * 查询子留言
     * @param message
     */
    void findParentMessage(Message message);

}