package com.lx.service.impl;

import com.lx.entity.Permission;
import com.lx.entity.Role;
import com.lx.entity.User;
import com.lx.mapper.LoginMapper;
import com.lx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User loginCheck(String username, String password) {
        return loginMapper.loginCheck(username,password);
    }

    @Override
    public void registerUser(User user) {

       loginMapper.registerUser(user);
    }

    @Override
    public Set<Role> findRoles(String username) {
        return loginMapper.findRoles(username);
    }

    @Override
    public Set<Permission> findPermission(String username) {
        return loginMapper.findPermission(username);
    }

    @Override
    public User findByUsername(String username) {
        return loginMapper.findByUsername(username);
    }
}
