package com.wcy.util;

/**
 * Created by wcy on 2017/7/11.
 */
public interface Dict {

    public enum Message{
        SUCCESS("SUCCESS","成功访问"),
        FAIL("FAIL","访问失败");
        private String name;
        private String msg;

       Message(String name,String msg){
           this.name = name;
           this.msg = msg;
       }

        public String getMsg() {
            return msg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public  interface TulinMsgType{
        /**
         * 文本消息
         */
        public final String TEXT_MESSAGE = "textMessage";
        /**
         * 链接类消息
         */
        public final String LINK_MESSAGE = "linkMessage";
        /**
         * 新闻类消息
         */
        public final String NEWS_MESSAGE = "newsMessage";
    }

    public interface ReturnCode{
        /**
         * 系统成功响应
         */
        public final String SUCCESS = "1";
        /**
         * 系统请求失败
         */
        public final String FAIL = "0";
    }
}
