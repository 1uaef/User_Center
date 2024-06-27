package com.atg.user_center.controller;

import com.atg.user_center.model.domain.User;
import com.atg.user_center.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
author: atg
time: 2024/6/27 22:31
*/
@RestController
@RequestMapping(value = "/test")
public class TestUser {
    @Resource
    private UserService userService;
    @GetMapping(value = "{id}")
    public User getUser(@PathVariable("id") Long id)
    {
        User user = userService.getById(id);
        return user;
    }

}
