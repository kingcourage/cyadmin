package com.wcy.adminapi.service;

import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.model.Role;

import java.util.List;

public interface ResourceService {
    Resource getResourceByUrl(String url);

    List<Role> getRolesById(Long id);
}
