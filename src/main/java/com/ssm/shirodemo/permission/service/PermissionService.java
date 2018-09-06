package com.ssm.shirodemo.permission.service;

import com.ssm.shirodemo.permission.model.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> selectPermissionByRoleId(String roleId);

}
