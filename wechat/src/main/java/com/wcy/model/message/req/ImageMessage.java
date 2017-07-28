package com.wcy.model.message.req;

/**
 * Created by wcy on 2017/7/1.
 */
public class ImageMessage extends BaseMessage {

    //图片链接

    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        this.PicUrl = picUrl;
    }

}
