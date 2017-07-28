package com.wcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String menu(){
        return "menu";
    }

    @RequestMapping(value = "")
    public String addMenu(HttpServletRequest request){
        String parentid = request.getParameter("parentid");
        request.setAttribute("parentid",parentid);
        return "addmenu";
    }

}
