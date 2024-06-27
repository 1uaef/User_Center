package com.atg.user_center.controller;


import com.atg.user_center.model.domain.User;
import com.atg.user_center.model.request.userLoginBody;
import com.atg.user_center.model.request.userRegisterBody;
import com.atg.user_center.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*
author: atg
time: 2024/6/28 10:25
*/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/register")
    public Long userRegister(@RequestBody userRegisterBody RegisterBody) {
        if (RegisterBody == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        String userAccount = RegisterBody.getUserAccount();
        String userPassword = RegisterBody.getPassword();
        String checkPassword = RegisterBody.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }

        return userService.userRegister(userAccount, userPassword, checkPassword);

    }

    @PostMapping(value = "/login")
    public User userLogin(@RequestBody userLoginBody LoginBody , HttpServletRequest request) {
        if (LoginBody == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        String userAccount = LoginBody.getUserAccount();
        String userPassword = LoginBody.getPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }

        User user = userService.userLogin(userAccount, userPassword, request);

        return user;
    }


}
