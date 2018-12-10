package com.wcy.adminapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/admin/index")
    public String index(){
        return "admin/index";
    }
}
