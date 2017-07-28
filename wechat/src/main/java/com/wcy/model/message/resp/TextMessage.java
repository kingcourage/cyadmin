package com.wcy.model.message.resp;

/**
 * Created by wcy on 2017/7/1.
 */
public class TextMessage extends BaseMessage {
    //回复消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }


}
