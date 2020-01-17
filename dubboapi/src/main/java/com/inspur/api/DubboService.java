package com.inspur.api;

import com.inspur.domain.model.User;

/**
 * @author wang.ning
 * @create 2020-01-07 16:41
 */
public interface DubboService {

    String sayHello();

    User getUserById(Long int_id);

}
