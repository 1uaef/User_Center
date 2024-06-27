package com.atg.user_center.service.impl;

import com.atg.user_center.mapper.UserMapper;
import com.atg.user_center.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atg.user_center.model.domain.User;

import org.springframework.stereotype.Service;

/**
 * @author 啊汤哥
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-06-27 21:32:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}




