package com.ssm.shirodemo.shiro;

import com.ssm.shirodemo.permission.model.Permission;
import com.ssm.shirodemo.permission.service.PermissionService;
import com.ssm.shirodemo.role.model.Role;
import com.ssm.shirodemo.user.model.User;
import com.ssm.shirodemo.user.service.UserService;
import org.apache.catalina.manager.util.SessionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Relam，从而实现自定的角色认证和授权管理
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;

    /**
     * 权限信息（授权）
     * 1、用户正常退出，缓存自动清空
     * 2、用户非正常退出，缓存自动清空
     * 3、修改用户权限，用户不退出系统，修改的权限无法自动生效（需要手动编程实现，放在Service中调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，调用clearCached方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置：ShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取用户主体信息
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.selectByUserName(userName);
        if(user == null){
            return null;
        }
        // 获取用户的权限信息，存放该用户信息到缓存中，之后就不需要一直查询数据库
        String roleId = user.getUserRoleId();
        List<Permission> permissionList = permissionService.selectPermissionByRoleId(roleId);
        // 设置权限信息. 将权限对象中的权限code取出.
        authorizationInfo.setStringPermissions(getStringPermissions(permissionList));
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param token  是用来验证用户身份
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("ShiroRealm.doGetAuthenticationInfo：认证方法");

        // 获取用户输入的账号信息
        String userName = (String) token.getPrincipal();
        // 这里根据获取到userName去数据库查找用户的信息
        // 这里可以做缓存处理，缓存当前用户，这样就不用每次都去数据库查询用户，Shiro也有间隔方法，两分钟之内不会重复执行
        User user = userService.selectByUserName(userName);
        if(user == null){
            return null;
        }
        // 用户，密码，加密方式，类名
        //SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,user.getUserPassword(),ByteSource.Util.bytes("123"),this.getName());
        // 没有加密
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,user.getUserPassword(),this.getName());
        return authenticationInfo;
    }

    /**
     * 将权限对象中的权限code取出.
     * @param permissions
     * @return
     */
    public Set<String> getStringPermissions(List<Permission> permissions) {
        Set<String> stringPermissions = new HashSet<String>();
        if (permissions != null) {
            for (Permission p : permissions) {
                stringPermissions.add(p.getCode());
            }
        }
        return stringPermissions;
    }
}
