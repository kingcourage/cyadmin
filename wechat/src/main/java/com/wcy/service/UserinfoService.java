package com.wcy.service;

import com.wcy.model.entity.Userinfo;


public interface UserinfoService {
    /**
     * 添加用户
     * @param userinfo
     * @return
     */
    public Userinfo addUser(Userinfo userinfo) throws Exception;


    /**
     * 登录校验
     * @param userinfo
     * @return
     * @throws Exception
     */
    public Userinfo loginCheck(Userinfo userinfo) throws Exception;
}
