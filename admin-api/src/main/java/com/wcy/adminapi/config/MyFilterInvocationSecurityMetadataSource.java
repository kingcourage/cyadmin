package com.wcy.adminapi.config;

import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.model.Role;
import com.wcy.adminapi.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Slf4j
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceService resourceService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        log.info("用户请求的地址为{}",requestUrl);

        //如果登录页面就不需要权限
        if ("/login".equals(requestUrl)) {
            return null;
        }
        Resource resource = resourceService.getResourceByUrl(requestUrl);
        //没有匹配的url
        if(resource == null){
            return SecurityConfig.createList("ROLE_LOGIN");
        }

        //返回访问资源所需的角色
        List<Role> roleList = resourceService.getRolesById(resource.getId());
        int size = roleList.size();
        String[] values = new String[size];
        for (int i = 0; i < size; i++) {
            values[i] = roleList.get(i).getName();
        }
        return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
