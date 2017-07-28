package com.wcy.service.core;

import com.wcy.model.message.resp.Article;
import com.wcy.model.message.resp.NewsMessage;
import com.wcy.model.message.resp.TextMessage;
import com.wcy.model.message.tuling.LinkMessage;
import com.wcy.model.message.tuling.News;
import com.wcy.model.message.tuling.ReqMessage;
import com.wcy.util.Dict;
import com.wcy.util.MessageUtil;
import com.wcy.util.TulingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wcy on 2017/7/1.
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService {

    private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    /**
     * 判断是否是QQ表情
     *
     * @param content
     * @return
     */
    public static boolean isQqFace(String content) {
        boolean result = false;

        // 判断QQ表情的正则表达式
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
        Pattern p = Pattern.compile(qqfaceRegex);
        Matcher m = p.matcher(content);
        if (m.matches()) {
            result = true;
        }
        return result;
    }

    @Override
    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            String respContent = "请求处理异常，请稍后尝试";
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            log.info("收到消息" + requestMap.toString());
            //发送方账号
            String fromUserName = requestMap.get("FromUserName");
            //公众账号
            String toUserName = requestMap.get("ToUserName");
            //消息类型
            String msgType = requestMap.get("MsgType");

            //回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);


            //创建图文消息
            NewsMessage newsMessage = new NewsMessage();
            newsMessage.setToUserName(fromUserName);
            newsMessage.setFromUserName(toUserName);
            newsMessage.setCreateTime(new Date().getTime());
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
            newsMessage.setFuncFlag(0);

            List<Article> articleList = new ArrayList<>();
            //接受文本消息
            String content = requestMap.get("Content");
            //自动回复文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

                //如果用户发送表情，则回复同样表情。
                if (isQqFace(content)) {
                    respContent = content;
                    textMessage.setContent(respContent);
                    // 将文本消息对象转换成xml字符串
                    respMessage = MessageUtil.textMessageToXml(textMessage);
                } else {
                    //回复固定消息
                    log.info("content:" + content);
                    ReqMessage reqMessage = new ReqMessage();
                    reqMessage.setInfo(content);
                    reqMessage.setUserid(fromUserName);
                    Map resultMap = TulingUtil.result(reqMessage);
                    if(Dict.TulinMsgType.TEXT_MESSAGE.equals(resultMap.get("msgType"))){
                            com.wcy.model.message.tuling.TextMessage tulinTextMessage = (com.wcy.model.message.tuling.TextMessage) resultMap.get("result");
                            textMessage.setContent(tulinTextMessage.getText());
                            respMessage = MessageUtil.textMessageToXml(textMessage);
                    }else if(Dict.TulinMsgType.LINK_MESSAGE.equals(resultMap.get("msgType"))){
                            LinkMessage tulinLinkMessage = (LinkMessage) resultMap.get("result");
                            Article article = new Article();
                            article.setTitle(tulinLinkMessage.getText());
                            article.setDescription(tulinLinkMessage.getText());
                            article.setPicUrl(tulinLinkMessage.getUrl());
                            article.setUrl(tulinLinkMessage.getUrl());
                            articleList.add(article);
                            newsMessage.setArticles(articleList);
                            newsMessage.setArticleCount(articleList.size());
                            respMessage = MessageUtil.newsMessageToXml(newsMessage);
                    }else if(Dict.TulinMsgType.NEWS_MESSAGE.equals(resultMap.get("msgType"))){
                            List<News> newsList = (List<News>) resultMap.get("result");
                            for(News news : newsList){
                                Article article = new Article();
                                article.setTitle(news.getSource());
                                article.setDescription(news.getArticle());
                                article.setPicUrl(news.getIcon());
                                article.setUrl(news.getDetailurl());
                                articleList.add(article);
                            }
                            newsMessage.setArticleCount(articleList.size());
                            newsMessage.setArticles(articleList);
                            respMessage = MessageUtil.newsMessageToXml(newsMessage);
                    }
                }
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
                textMessage.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
                textMessage.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
                textMessage.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = MessageUtil.textMessageToXml(textMessage);

            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
                textMessage.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
                String event = requestMap.get("Event");
                if(event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
                    respContent = "欢迎关注王长勇的微信公众号[Smirk][Smirk][Smirk][Smirk]";
                }else if("KEY_1".equals(requestMap.get("EventKey"))){
                    respContent = "你是傻逼";
                }else{
                    respContent = "开发中";
                };
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}

