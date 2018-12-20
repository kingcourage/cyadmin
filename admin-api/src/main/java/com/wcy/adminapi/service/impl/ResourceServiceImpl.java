package com.wcy.adminapi.service.impl;

import com.wcy.adminapi.dao.ResourceDao;
import com.wcy.adminapi.dao.Role2ResourceDao;
import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.model.Role;
import com.wcy.adminapi.model.Role2Resource;
import com.wcy.adminapi.service.ResourceService;
import com.wcy.adminapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private Role2ResourceDao role2ResourceDao;

    @Autowired
    private RoleService roleService;

    @Override
    public Resource getResourceByUrl(String url) {
        return resourceDao.getResourceByUrlEquals(url);
    }

    @Override
    public List<Role> getRolesById(Long id) {
       List<Role2Resource> role2Resources =  role2ResourceDao.getRole2ResourceByResourceIdEquals(id);
       return roleService.getRolesByIdIn(role2Resources.stream().map(item->item.getRoleId()).collect(Collectors.toList()));
    }

    @Override
    public List<Resource> getResourceByUserIdAndType(Long userId, Integer type) {
        List<Role> roleList = roleService.getRolesByUserId(userId);
        if(roleList.size() > 0){
            List<Role2Resource> role2Resources = role2ResourceDao.getRole2ResourceByRoleIdIn(roleList.stream().map(item->item.getId()).collect(Collectors.toList()));
            if(role2Resources.size() > 0){
                //找到对应的菜单
               return resourceDao.getResourcesByTypeEqualsAndIdIn(type,role2Resources.stream().map(item->item.getResourceId()).collect(Collectors.toList()));
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List<Resource> getResourceByParentId(Long parentId) {
        return resourceDao.getResourcesByParentIdEquals(parentId);
    }
}
