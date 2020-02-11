package com.inspur.consumer.service.impl;

import com.inspur.api.DubboService;
import com.inspur.consumer.service.ConsumerService;
import com.inspur.domain.model.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author wang.ning
 * @create 2020-01-07 17:22
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

    @Reference
    DubboService dubboService;

    @Override
    public String invoke(String name) {
        return dubboService.sayHello();
    }

    @Override
    public User findUser(Long int_id) {
        //return dubboService.getUserById(int_id);
        return null;
    }


}
