package com.inspur.mybatis.mapper;

import com.inspur.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wang.ning
 * @create 2020-01-13 15:49
 */
@Mapper
public interface UserMapper {

    User findUser(Long int_id);

}
