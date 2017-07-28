package com.wcy.controller;

import com.wcy.model.entity.Userinfo;
import com.wcy.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController{

    @Autowired
    UserinfoService userinfoService;

    @RequestMapping("")
    public String register() {
        return "register";
    }


    @RequestMapping(value = "/saveUser")
    public String saveUser(Userinfo userinfo, ModelMap model, HttpServletRequest request){
        try {
            userinfo = userinfoService.addUser(userinfo);
            if(userinfo!=null){
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userinfo",userinfo);
        return "register";
    }
}