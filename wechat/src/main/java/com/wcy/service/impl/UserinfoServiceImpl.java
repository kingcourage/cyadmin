package com.wcy.service.impl;

import com.wcy.dao.UserinfoMapper;
import com.wcy.model.entity.Userinfo;
import com.wcy.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo addUser(Userinfo userinfo) throws Exception{
        int count = userinfoMapper.insertSelective(userinfo);
        if(count > 0){
            return  userinfo;
        }else{
            return  null;
        }
    }

    @Override
    public Userinfo loginCheck(Userinfo userinfo) throws Exception {
        return userinfoMapper.loginCheck(userinfo);
    }


}
