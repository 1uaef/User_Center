package com.atg.user_center.common;

import lombok.Data;

import java.io.Serializable;

/*
author: atg
time: 2024/6/28 21:37
description: 返回状态的封装
*/
@Data
public class BaseResponse<T> implements Serializable {

    private int code; //状态码
    private T data; //返回的数据
    private String message; //返回的信息
    private String description; //返回的描述

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    // 返回错误信息
    public BaseResponse(ErrorCode errorCode)
    {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.description = errorCode.getDescription();
        this.data = null;


    }


}
