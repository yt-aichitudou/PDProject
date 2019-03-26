package com.lx.mapper;

import com.lx.entity.Permission;
import com.lx.entity.Role;
import com.lx.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface LoginMapper {
    User loginCheck(@Param(value = "username") String username, @Param(value = "password") String password);

    void registerUser(User user);

    Set<Role> findRoles(String username);

    Set<Permission> findPermission(String username);

    User findByUsername(String username);
}
