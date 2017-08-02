package com.wcy.controller;


import com.wcy.service.core.MenuService;
import com.wcy.service.core.CoreService;
import com.wcy.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wcy on 2017/7/1.
 */
@Controller
@RequestMapping("/weixin")
public class CoreController {

    @Autowired
    private StringRedisTemplate template;

    //增加日志
    private static Logger log = LoggerFactory.getLogger(CoreController.class);
    @Autowired
    private CoreService coreService;

    //验证是否来自微信服务器
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void checkSignature(@RequestParam(name = "signature", required = false) String signature,
                                 @RequestParam(name = "nonce", required = false) String nonce,
                                 @RequestParam(name = "timestamp", required = false) String timestamp,
                                 @RequestParam(name = "echostr", required = false) String echostr,
                                 HttpServletResponse response) throws IOException {
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("接入成功");
            response.getWriter().print(echostr);
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void post(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String respMessage = coreService.processRequest(request);
        log.info("返回消息" + respMessage);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(respMessage);
    }

}
