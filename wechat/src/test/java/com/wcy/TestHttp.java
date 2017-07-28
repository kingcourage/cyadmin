package com.wcy;

import com.wcy.util.HttpUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wcy on 2017/7/2.
 */
public class TestHttp {
    Logger log = LoggerFactory.getLogger(TestHttp.class);

    @Test
    public void getToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxdcfb18142f659774&secret=4b633996e7e552c2a68858f03f6dcbdd";
        String param = "";
        String result = HttpUtil.sendPost(url, param);
        log.info(result);
    }
}
