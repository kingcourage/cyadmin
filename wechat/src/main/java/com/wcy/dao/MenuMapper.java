package com.wcy.dao;

import com.wcy.model.entity.Menu;
import com.wcy.model.entity.MenuModel;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<MenuModel>  menuList(MenuModel menu);
}