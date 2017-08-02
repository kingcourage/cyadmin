package com.wcy.dao;

import com.wcy.model.entity.Userinfo;
import org.springframework.stereotype.Repository;


public interface UserinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    public Userinfo loginCheck(Userinfo record);
}