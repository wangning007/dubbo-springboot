package com.inspur.consumer;

import com.inspur.consumer.service.ConsumerService;
import com.inspur.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang.ning
 * @create 2020-01-07 17:19
 */
@RestController
@RequestMapping("comsumer")
public class DubboConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping("test")
    public User test(){
        return consumerService.findUser(123L);
    }

}
