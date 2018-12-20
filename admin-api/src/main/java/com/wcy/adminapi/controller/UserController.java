package com.wcy.adminapi.controller;

import com.wcy.adminapi.model.User;
import com.wcy.adminapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        return "user/userIndex";
    }

    @RequestMapping("page_data")
    @ResponseBody
    public List<User> userList(){
        return userService.queryUserList();
    }
}
