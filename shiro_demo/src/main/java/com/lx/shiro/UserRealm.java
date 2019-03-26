package com.lx.shiro;

import com.lx.entity.Permission;
import com.lx.entity.Role;
import com.lx.entity.User;
import com.lx.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /**
     * 提供用户信息返回角色权限信息
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<Role> roles = loginService.findRoles(username);
        Set<String> roleNames = new HashSet<>();
        for (Role role : roles) {
            roleNames.add(role.getRole());
        }
        //将角色提供给simpleAuthorizationInfo
        simpleAuthorizationInfo.setRoles(roleNames);

        //根据用户名查询当前用户权限
        Set<Permission> permissions = loginService.findPermission(username);
        Set<String> permissionNames = new HashSet<String>();
        for (Permission permission : permissions) {
            permissionNames.add(permission.getPermission());
        }
        // 将权限名称提供给info
        simpleAuthorizationInfo.setStringPermissions(permissionNames);
        return simpleAuthorizationInfo;
    }
    /**
     * 提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = loginService.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        if (user.getLocked() == 2) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return authenticationInfo;
    }
}
