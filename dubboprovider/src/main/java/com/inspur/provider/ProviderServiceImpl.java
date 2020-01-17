package com.inspur.provider;

import com.inspur.api.DubboService;
import com.inspur.domain.model.User;
import com.inspur.mybatis.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import javax.annotation.Resource;

/**
 * @author wang.ning
 * @create 2020-01-07 16:50
 */
@Service(interfaceName="dubboService")
public class ProviderServiceImpl implements DubboService {

    @Resource
    private UserMapper userMapper;

    public String sayHello() {
        return "annotation:hello!!";
    }

    @Override
    public User getUserById(Long int_id) {
        return userMapper.findUser(int_id);
    }

}
