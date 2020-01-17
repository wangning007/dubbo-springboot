package com.inspur.consumer.service;

import com.inspur.domain.model.User;

/**
 * @author wang.ning
 * @create 2020-01-07 17:21
 */
public interface ConsumerService {

    String invoke(String name);

    public User findUser(Long int_id);
}
