package com.atg.user_center.common;

/*
author: atg
time: 2024/6/28 21:57
*/
public class ResultUtils {
    /**
     * 创建成功返回结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "success");
    }

    /**
     * 创建失败返回结果
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }


    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    public static BaseResponse error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse(errorCode.getCode(), null, message, description);
    }

    public static BaseResponse error(ErrorCode errorCode, String description) {
        return new BaseResponse(errorCode.getCode(), errorCode.getMessage(), description);
    }

}


