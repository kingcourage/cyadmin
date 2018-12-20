package com.wcy.adminapi.service;

import com.wcy.adminapi.model.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    User getUserByUsername(String username);
    List<User> queryUserList();
}
