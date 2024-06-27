package com.atg.user_center.service.impl;
import java.util.Date;

import com.atg.user_center.mapper.UserMapper;
import com.atg.user_center.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atg.user_center.model.domain.User;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 啊汤哥
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-06-27 21:32:58
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    private  static final String Salt = "atg";
    @Override
    public Long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1.非空
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)){
            return (long) -1;
        }

        // 2.账户长度
        if (!(userAccount.length() >= 3) || !(userAccount.length() <= 10)){
            return (long) -1;
        }
        // 3.账户长度不含特殊字符
        if (!userAccount.matches("^[a-zA-Z0-9]+$")){
            return (long) -1;
        }

        // 4.密码长度
        if (!(userPassword.length() >= 6) || !(userPassword.length() <= 20)){
            return (long) -1;
        }

        // 5.密码相同
        if (!userPassword.equals(checkPassword)){
            return (long) -1;
        }
        // 6.账户是否可用
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            return (long) -1;
        }
        // 7.存入数据库
        // 7.1 密码加密
        String encryptPassword = DigestUtils.md5DigestAsHex((Salt + userPassword).getBytes());
        // 7.1插入数据
        User user1 = new User();
        user1.setUserAccount(userAccount);
        user1.setPassword(encryptPassword);
        boolean saveResult = this.save(user1);
        if (!saveResult)
        {
            return (long) -1;
        }
        return user1.getId();
    }

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 1.非空
        if (StringUtils.isAnyBlank(userAccount, userPassword)){
            return null;
        }
        // 2.账户长度
        if (!(userAccount.length() >= 3) || !(userAccount.length() <= 10)){
            return null;
        }

        // 3.账户长度不含特殊字符
        if (!userAccount.matches("^[a-zA-Z0-9]+$")){
            return null;
        }
        // 4.密码长度
        if (!(userPassword.length() >= 6) || !(userPassword.length() <= 20)){
            return null;
        }
        // 4.1 密码加密

        String encryptPassword = DigestUtils.md5DigestAsHex((Salt + userPassword).getBytes());

        // 5.查询用户是否存在

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("password", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
        }
        // 6.脱敏处理
        User safetyUser = new User();
        safetyUser.setId(user.getId());
        safetyUser.setUsername(user.getUsername());
        safetyUser.setUserAccount(user.getUserAccount());
        safetyUser.setGender(user.getGender());
        safetyUser.setPhone(user.getPhone());
        safetyUser.setCreateTime(new Date());
        safetyUser.setUpdateTime(new Date());
        safetyUser.setUserRole(user.getUserRole());



        // 记录用户状态
        request.getSession().setAttribute("user", safetyUser);
        return safetyUser;
    }

    public User getSafetyUser(User originUser) {
        if (originUser == null) {
            return null;
        }
        User safetyUser = new User();
        safetyUser.setId(originUser.getId());
        safetyUser.setUsername(originUser.getUsername());
        safetyUser.setUserAccount(originUser.getUserAccount());
        safetyUser.setAvatarUrl(originUser.getAvatarUrl());
        safetyUser.setGender(originUser.getGender());
        safetyUser.setPhone(originUser.getPhone());
        safetyUser.setEmail(originUser.getEmail());
//        safetyUser.setPlanetCode(originUser.getPlanetCode());
//        safetyUser.setUserRole(originUser.getUserRole());
        safetyUser.setUserStatus(originUser.getUserStatus());
        safetyUser.setCreateTime(originUser.getCreateTime());
        return safetyUser;
    }

}




