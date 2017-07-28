package com.wcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }


    @RequestMapping("/page")
    public String indexPage(){
        return "index_v1";
    }
}
