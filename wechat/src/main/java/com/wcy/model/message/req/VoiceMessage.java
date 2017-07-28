package com.wcy.model.message.req;

/**
 * Created by wcy on 2017/7/1.
 */
public class VoiceMessage {
    //媒体id
    private String MediaId;
    //语音格式
    private String format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
