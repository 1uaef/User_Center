package com.atg.user_center.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id(主键)
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录账号


     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 性别

     */
    private Integer gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱

     */
    private String email;

    /**
     * 状态0-正常
     */
    private Integer userStatus;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 是否删除
     * 逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 
     */
    private Integer new_column;

    /**
     * 用户角色 0 - 普通用户 1 - 管理员
     */
    private Integer userRole;

    /**
     * 星球编号
     */
    private String planetCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}