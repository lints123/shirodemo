package com.ssm.shirodemo.permission.service.impl;


import com.ssm.shirodemo.permission.mapper.PermissionMapper;
import com.ssm.shirodemo.permission.model.Permission;
import com.ssm.shirodemo.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectPermissionByRoleId(String roleId) {
        return permissionMapper.selectPermissionByRoleId(roleId);
    }
}
