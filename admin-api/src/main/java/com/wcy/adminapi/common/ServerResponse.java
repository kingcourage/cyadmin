package com.wcy.adminapi.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServerResponse<T> {
    private Integer status;
    private String message;
    private T data;

    private ServerResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ServerResponse createBySuccess(){
        return new ServerResponse(0,"success",null);
    }
    public static ServerResponse createBySuccessWithData(Object data){
        return new ServerResponse(0,"success",data);
    }

    public static  ServerResponse createByErrorMessage(String message){
        return new ServerResponse(1,message,null);
    }
}
