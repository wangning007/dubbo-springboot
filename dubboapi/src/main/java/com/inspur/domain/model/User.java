package com.inspur.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wang.ning
 * @create 2020-01-13 16:20
 */
@Data
public class User implements Serializable {

    private Long int_id;

    private String username;

    private String address;

    private String password;

    private String email;

    private String info;

    private Date create_time;

    private byte[] head_img;

}
