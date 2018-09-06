package com.ssm.shirodemo.user.service;

import com.ssm.shirodemo.user.model.User;

public interface UserService {
    User selectByUserName(String userName);
}
