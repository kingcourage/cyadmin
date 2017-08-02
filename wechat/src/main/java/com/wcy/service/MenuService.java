package com.wcy.service;

import com.wcy.model.entity.Menu;
import com.wcy.model.entity.MenuModel;

import java.util.List;

public interface MenuService {
    /**
     * 查看菜单列表
     * @return
     */
    public List<MenuModel> menuList(MenuModel menu) throws Exception;

    /**
     * 保存菜单
     * @param menu
     * @return
     */
    public Menu saveMneu(Menu menu) throws Exception;


    /**
     * 删除菜单
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteMneu(Long id) throws Exception;

    /**
     * 得到当前菜单节点的子节点
     * @param menu
     * @return
     * @throws Exception
     */
    public List<MenuModel> chrildList(MenuModel menu) throws Exception;
}
