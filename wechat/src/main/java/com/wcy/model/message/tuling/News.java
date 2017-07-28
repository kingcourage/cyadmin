package com.wcy.model.message.tuling;

/**
 * 新闻类消息的基本单元
 * Created by wcy on 2017/7/11.
 */
public class News {
    private String article;  //新闻标题
    private String source;   //新闻来源
    private String icon;     //新闻图片
    private String detailurl;//新闻详情链接

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }
}
