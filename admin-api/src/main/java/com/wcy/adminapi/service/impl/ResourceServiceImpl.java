package com.wcy.adminapi.service.impl;

import com.wcy.adminapi.dao.ResourceDao;
import com.wcy.adminapi.dao.Role2ResourceDao;
import com.wcy.adminapi.dao.RoleDao;
import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.model.Role;
import com.wcy.adminapi.model.Role2Resource;
import com.wcy.adminapi.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private Role2ResourceDao role2ResourceDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public Resource getResourceByUrl(String url) {
        return resourceDao.getResourceByUrlEquals(url);
    }

    @Override
    public List<Role> getRolesById(Long id) {
       List<Role2Resource> role2Resources =  role2ResourceDao.getRole2ResourceByResourceIdEquals(id);
       return roleDao.getRolesByIdIn(role2Resources.stream().map(item->item.getRoleId()).collect(Collectors.toList()));
    }
}
