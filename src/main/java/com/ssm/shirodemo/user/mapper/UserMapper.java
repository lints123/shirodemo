package com.ssm.shirodemo.user.mapper;

import com.ssm.shirodemo.user.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 根据用户名返回用户信息
    User selectByUserName(String userName);
}