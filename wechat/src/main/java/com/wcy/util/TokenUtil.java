package com.wcy.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


/**
 * Created by wcy on 2017/7/2.
 */

@Component
public class TokenUtil {

    @Autowired
    private StringRedisTemplate template;


    static Logger log = LoggerFactory.getLogger(TokenUtil.class);

    private  String token() {
        log.info("请求token开始");
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx11af04aaaad6fe3b&secret=04a766df2510d31e4bde99cfbcd62d5d";
        String param = "";
        String result = HttpUtil.sendPost(url, param);
        log.info("返回结果" + result);
        JSONObject json = JSONObject.parseObject(result);
        String token = json.getString("access_token");
        log.info("token为" + token);
        return token;
    }

    public  String getToken(){
        ValueOperations<String, String> ops = template.opsForValue();
        String token = ops.get("token");
        if(token == null){
            log.info("从redis没有获取到APPKEY");
            token = token();
            log.info("重新获取APPKEY");
            template.opsForValue().set("token",token,7200L);
            log.info("存入redisAPPKEY"+token);
        }else{
            log.info("从redis获取到的APPKEY为"+token);
        }
        return token;
    }

}
