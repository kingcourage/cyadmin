package com.wcy.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wcy.model.message.tuling.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wcy on 2017/7/4.
 */
public class TulingUtil {
    private static final String APP_KEY = "c9c69b5dd181bd42f545218056aa3371";
    private static Logger log = LoggerFactory.getLogger(TulingUtil.class);
    public static  Map result(ReqMessage reqMessage){
        log.info("向图灵机器人发送请求");
        String url2 = "http://www.tuling123.com/openapi/api?key="+APP_KEY+"&info="+reqMessage.getInfo()+"&userid="+reqMessage.getUserid();
        String url = url2.replaceAll(" ","");
        String jsonstr = "";
        Map resultMap = new HashMap();
        try{
            String result =  HttpUtil.sendPost(url,jsonstr);
            JSONObject json = JSONObject.parseObject(result);
            String code = json.getString("code");
            if("100000".equals(code)){
                log.info("返回的消息为文本类型");
                TextMessage message = new TextMessage();
                message = new TextMessage();
                message.setCode("100000");
                message.setText(json.getString("text"));
                resultMap.put("result",message);
                resultMap.put("msgType",Dict.TulinMsgType.TEXT_MESSAGE);
            }else if("200000".equals(code)){
                log.info("返回的消息为链接类型");
                LinkMessage message = new LinkMessage();
                message = new LinkMessage();
                message.setCode("200000");
                message.setText(json.getString("text"));
                message.setUrl(json.getString("url"));
                resultMap.put("result",message);
                resultMap.put("msgType",Dict.TulinMsgType.LINK_MESSAGE);
            }else if("302000".equals(code)){
                log.info("返回的消息为新闻类消息");
                NewsMessage message = new NewsMessage();
                JSONArray jsonArray = json.getJSONArray("list");
                List<News> newsList = jsonArray.toJavaList(News.class);
                message.setNewsList(newsList);
                message.setCode("302000");
                message.setText(json.getString("text"));
                resultMap.put("result",message);
                resultMap.put("msgType",Dict.TulinMsgType.NEWS_MESSAGE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultMap;
    }
}
