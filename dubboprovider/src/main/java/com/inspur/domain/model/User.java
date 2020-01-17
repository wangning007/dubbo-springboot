package com.inspur.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wang.ning
 * @create 2020-01-13 16:20
 */
@Data
public class User implements Serializable {

    private Long int_id;

    private String username;

    private String address;

}
