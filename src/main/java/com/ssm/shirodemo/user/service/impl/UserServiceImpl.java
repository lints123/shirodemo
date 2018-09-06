package com.ssm.shirodemo.user.service.impl;

import com.ssm.shirodemo.user.mapper.UserMapper;
import com.ssm.shirodemo.user.model.User;
import com.ssm.shirodemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}
