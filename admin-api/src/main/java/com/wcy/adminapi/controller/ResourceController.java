package com.wcy.adminapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resource/")
public class ResourceController {

    @RequestMapping("/index")
    public String index(){
        return "admin/resource";
    }
}