package com.wcy.model.message.tuling;

/**
 * 请求图灵机器人的数据类型
 * Created by wcy on 2017/7/4.
 */
public class ReqMessage {
    private String key;
    private String info;
    private String ioc;
    private String userid;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIoc() {
        return ioc;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
