package com.inspur.domain.model;

import lombok.Data;

import java.sql.Date;

/**
 * @author wang.ning
 * @create 2020-01-16 9:01
 */
@Data
public class SysRole {

    private Long intId;

    private String roleName;

    private int enabled;

    private Date createTime;

    private String creator;

}
