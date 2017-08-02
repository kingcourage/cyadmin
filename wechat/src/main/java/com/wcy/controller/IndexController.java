package com.wcy.controller;

import com.wcy.model.entity.MenuModel;
import com.wcy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "")
    public String index(HttpServletRequest request){
        try {
            List<MenuModel> menuModelList = menuService.menuList(null);
            request.setAttribute("menuList",menuModelList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }


    @RequestMapping("/page")
    public String indexPage(){
        return "index_v1";
    }
}
