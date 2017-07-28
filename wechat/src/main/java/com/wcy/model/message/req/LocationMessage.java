package com.wcy.model.message.req;

/**
 * Created by wcy on 2017/7/1.
 */
public class LocationMessage extends BaseMessage {
    //地理位置维度
    private String Location_x;
    //地理位置经度
    private String Location_y;
    //地图缩放大小
    private String Scale;
    //地理位置信息
    private String Label;

    public String getLocation_x() {
        return Location_x;
    }

    public void setLocation_x(String location_x) {
        this.Location_x = location_x;
    }

    public String getLocation_y() {
        return Location_y;
    }

    public void setLocation_y(String location_y) {
        this.Location_y = location_y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        this.Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
