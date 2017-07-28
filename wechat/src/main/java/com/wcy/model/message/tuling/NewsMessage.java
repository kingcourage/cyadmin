package com.wcy.model.message.tuling;

import java.util.List;

/**图灵机器人返回的新闻类消息
 * Created by wcy on 2017/7/11.
 */
public class NewsMessage extends BaseMessage {
    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    private List<News> newsList;
}
