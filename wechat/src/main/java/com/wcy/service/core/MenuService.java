package com.wcy.service.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wcy.util.HttpUtil;
import com.wcy.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wcy on 2017/7/2.
 */

@Service
public class MenuService {
    @Autowired
    TokenUtil tokenUtil;

    Logger log = LoggerFactory.getLogger(MenuService.class);

    public void changeMenu() {
        String token = tokenUtil.getToken();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + token;
        JSONObject json = new JSONObject();
        JSONArray menu = new JSONArray();
        JSONObject submenu1 = new JSONObject();
        JSONObject submenu2 = new JSONObject();
        JSONObject submenu3 = new JSONObject();
        JSONObject submenu4 = new JSONObject();
        JSONObject submenu5 = new JSONObject();
        JSONObject submenu6 = new JSONObject();
        JSONObject submenu8 = new JSONObject();
        JSONArray submenu7 = new JSONArray();
        submenu1.put("type","click");
        submenu1.put("name","我是谁");
        submenu1.put("key","KEY_1");

        submenu3.put("type","click");
        submenu3.put("name","歌曲");
        submenu3.put("key","KEY_2");

        submenu4.put("type","click");
        submenu4.put("name","图片");
        submenu4.put("key","KEY_3");
        submenu5.put("type","click");
        submenu5.put("name","笑话");
        submenu5.put("key","KEY_4");

        submenu7.add(submenu3);
        submenu7.add(submenu4);
        submenu7.add(submenu5);

        submenu8.put("type","view");
        submenu8.put("name","百度一下");
        submenu8.put("url","http://www.baidu.com");

        submenu2.put("name","娱乐");
        submenu2.put("sub_button",submenu7);
        menu.add(submenu1);
        menu.add(submenu2);
        menu.add(submenu8);
        json.put("button",menu);
        String param = "  {\n" +
                "     \"button\":[\n" +
                "     {\t\n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"今日歌曲\",\n" +
                "          \"key\":\"V1001_TODAY_MUSIC\"\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"菜单\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"搜索\",\n" +
                "               \"url\":\"http://www.soso.com/\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"click\",\n" +
                "               \"name\":\"赞一下我们\",\n" +
                "               \"key\":\"V1001_GOOD\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }";
        String jsonstr = json.toJSONString();
        log.info("菜单结构" + jsonstr);
        String result = HttpUtil.sendPost(url,jsonstr);

        log.info("改变菜单" + result);

    }
}
