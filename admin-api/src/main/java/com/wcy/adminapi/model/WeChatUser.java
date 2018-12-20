package com.wcy.adminapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class WeChatUser {
    private String openId;
    private String name;
}
