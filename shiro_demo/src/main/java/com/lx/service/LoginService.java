package com.lx.service;

import com.lx.entity.Permission;
import com.lx.entity.Role;
import com.lx.entity.User;

import java.util.Set;

public interface LoginService {
    User loginCheck(String username, String password);

    void registerUser(User user);

    Set<Role> findRoles(String username);

    Set<Permission> findPermission(String username);

    User findByUsername(String username);
}
