package com.wcy.model.message.tuling;

/**图灵机器人借口返回的链接类消息
 * Created by wcy on 2017/7/11.
 */
public class LinkMessage  extends BaseMessage{
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
