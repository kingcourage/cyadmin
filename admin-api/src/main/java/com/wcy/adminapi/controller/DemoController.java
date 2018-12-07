package com.wcy.adminapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Slf4j
public class DemoController {

    @RequestMapping("hello")
    public String hello(){
        log.info("hello");
        return "hello";
    }

}
