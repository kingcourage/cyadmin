package com.wcy.controller;


import com.wcy.model.entity.Userinfo;
import com.wcy.service.UserinfoService;
import com.wcy.util.Dict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserinfoService userinfoService;

    @RequestMapping(value = "" )
    public String login(){
        return "login";
    }
    /*@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login_v2(){
        return "login_v2";
    }*/


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginCheck(String username, String password, HttpServletRequest request, HttpServletResponse response, ModelMap model){
        logger.info("用户名:"+username+"----------密码:"+password);
        try {
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            userinfo = userinfoService.loginCheck(userinfo);
            if(userinfo != null){
                model.addAttribute("userinfo",userinfo);
                HttpSession session = request.getSession();
                session.setAttribute("CURRENT_USER",userinfo);
                Cookie cookie = new Cookie("username",userinfo.getUsername());
                cookie.setPath("/");
                response.addCookie(cookie);
                model.addAttribute("msg","hello");
                return  "index";
            }
        } catch (Exception e) {
            pageResponse.setCode(Dict.ReturnCode.FAIL);
            pageResponse.setMsg("访问发生错误");
            e.printStackTrace();
        }
        return "login";
    }

}
