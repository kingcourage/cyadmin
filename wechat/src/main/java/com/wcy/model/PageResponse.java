package com.wcy.model;

import com.wcy.util.Dict;

public class PageResponse<T> {
    private String code = Dict.ReturnCode.FAIL;//默认返回失败
    private  String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
