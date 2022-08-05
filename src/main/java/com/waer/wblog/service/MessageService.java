package com.waer.wblog.service;



import com.waer.wblog.entity.Message;

import java.util.List;


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


}