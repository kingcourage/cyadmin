package com.wcy.adminapi.service.impl;

import com.wcy.adminapi.dao.RoleDao;
import com.wcy.adminapi.dao.User2RoleDao;
import com.wcy.adminapi.model.Role;
import com.wcy.adminapi.model.User2Role;
import com.wcy.adminapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private User2RoleDao user2RoleDao;

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        List<User2Role> user2Roles = user2RoleDao.findAllByUserIdEquals(userId);
        List<Role> roles =  roleDao.getRolesByIdIn(user2Roles.stream().map(item->item.getRoleId()).collect(Collectors.toList()));
        return roles;
    }

    @Override
    public List<Role> getRolesByIdIn(List<Long> ids) {
        return roleDao.getRolesByIdIn(ids);
    }

    @Override
    public List<Role> getRoleList() {
        return roleDao.findAll();
    }
}
