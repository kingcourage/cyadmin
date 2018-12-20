package com.wcy.adminapi.controller;

import com.wcy.adminapi.model.Role;
import com.wcy.adminapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("index")
    public String  index(){
        return "role/roleIndex";
    }

    @RequestMapping("page_data")
    @ResponseBody
    public List<Role> pageData(){
        return roleService.getRoleList();
    }

}
