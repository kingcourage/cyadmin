package com.wcy.adminapi.service.impl;

import com.wcy.adminapi.dao.UserDao;
import com.wcy.adminapi.model.User;
import com.wcy.adminapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> queryUserList() {
        return userDao.findAll();
    }
}
