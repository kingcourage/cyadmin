package com.wcy.adminapi.controller;

import com.wcy.adminapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/login")
    public String loginPage(){
        return "admin/login";
    }

}
