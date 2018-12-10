package com.wcy.adminapi.controller;

import com.wcy.adminapi.common.ServerResponse;
import com.wcy.adminapi.model.User;
import com.wcy.adminapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/login")
    public String loginPage(){
        return "admin/login";
    }

}
