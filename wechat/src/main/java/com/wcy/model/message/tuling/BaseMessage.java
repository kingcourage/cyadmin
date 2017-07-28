package com.wcy.model.message.tuling;

/**
 * 图灵机器人返回的基本数据类型
 * Created by wcy on 2017/7/4.
 */
public class BaseMessage {
    private String code;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
