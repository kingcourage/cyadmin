package com.wcy.adminapi.service;

import com.wcy.adminapi.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesByUserId(Long userId);
}
