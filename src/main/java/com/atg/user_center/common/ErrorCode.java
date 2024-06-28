package com.atg.user_center.common;

/*
author: atg
time: 2024/6/28 21:43
description: 返回错误信息
*/
public enum ErrorCode{
    SUCCESS(200, "操作成功", ""),
    PARAMS_ERROR(400, "请求参数错误", ""),
    NULL_ERROR(404, "请求数据为空", ""),
    NOT_FOUND_ERROR(404, "请求数据不存在", ""),
    FORBIDDEN_ERROR(403, "禁止访问", ""),
    SYSTEM_ERROR(500, "系统内部异常", ""),
    NO_AUTH(401, "无权限", ""),
    OPERATION_ERROR(500, "操作失败", "");


    private final String message;
    private final int code;
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
