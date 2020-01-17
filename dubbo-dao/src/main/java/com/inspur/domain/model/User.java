package com.inspur.domain.model;

import lombok.Data;

import java.sql.Date;

/**
 * @author wang.ning
 * @create 2020-01-14 12:33
 */
@Data
public class User {

    private Long intId;

    private String username;

    private String address;

    private String password;

    private String email;

    private String info;

    private byte[] headImg;

    private Date createTime;
}
