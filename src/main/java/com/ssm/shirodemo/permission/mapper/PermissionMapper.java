package com.ssm.shirodemo.permission.mapper;

import com.ssm.shirodemo.permission.model.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    // 根据角色id，获取角色权限
    List<Permission> selectPermissionByRoleId(String roleId);
}