package com.ailk.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PageData {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private Date createTime;
}
