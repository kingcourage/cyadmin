package com.wcy.adminapi.service;

import com.wcy.adminapi.model.User;

public interface UserService {
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
