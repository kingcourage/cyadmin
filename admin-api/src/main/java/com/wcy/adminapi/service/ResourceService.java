package com.wcy.adminapi.service;

import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.model.Role;

import java.util.List;

public interface ResourceService {
    /**
     * 根据url获取对应资源
     * @param url
     * @return
     */
    Resource getResourceByUrl(String url);

    /**
     * 根据资源id，获取可以访问此资源的角色列表
     * @param id
     * @return
     */
    List<Role> getRolesById(Long id);

    /**
     * 根据用户id获取能访问的菜单列表
     * @param userId
     * @param type
     * @return
     */
    List<Resource> getResourceByUserIdAndType(Long userId, Integer type);

    /**
     * 根据父级id获取资源
     * @param parentId
     * @return
     */
    List<Resource> getResourceByParentId(Long parentId);

    /**
     *
     * @param type
     * @return
     */
    List<Resource> getResourceByType(Integer type);
}
