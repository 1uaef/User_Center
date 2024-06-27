package com.atg.user_center.service;
import java.util.Date;

import com.atg.user_center.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/*
author: atg
time: 2024/6/27 21:41
*/
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    public void testAddUser()
    {
        User user = new User();
        user.setUsername("atg");
        user.setUserAccount("23");
        user.setGender(0);
        user.setPassword("11234");
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);

        boolean saveResult = userService.save(user);
        Assertions.assertTrue(saveResult);
        System.out.println(user.getId());


    }




}