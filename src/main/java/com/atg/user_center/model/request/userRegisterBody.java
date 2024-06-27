package com.atg.user_center.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/*
author: atg
time: 2024/6/28 10:31
*/
@Data
public class userRegisterBody implements Serializable {
    /**
     * 请求体的封装
     */
    // 生成uid

    private static final UUID serialVersionUID = UUID.randomUUID();

    private String userAccount;

    private String password;

    private String checkPassword;


}
