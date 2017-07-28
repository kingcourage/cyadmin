package com.wcy.model.message.req;

/**
 * Created by wcy on 2017/7/1.
 */
public class MenuMessage extends BaseMessage {
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        this.EventKey = eventKey;
    }
}
