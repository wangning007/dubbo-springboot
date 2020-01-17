package com.inspur.mybatis.mapper;

import com.inspur.domain.model.SysRole;
import com.inspur.domain.model.User;

import java.util.List;

/**
 * @author wang.ning
 * @create 2020-01-16 10:57
 */
public interface SysUserMapper {

    User findUserById(Long intId);

    List<User> findAll();

    List<SysRole> findRolesByUserId(Long userId);
}
