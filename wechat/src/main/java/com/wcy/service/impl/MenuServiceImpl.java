package com.wcy.service.impl;

import com.wcy.dao.MenuMapper;
import com.wcy.model.entity.Menu;
import com.wcy.model.entity.MenuModel;
import com.wcy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuModel> menuList(MenuModel menu) {
       MenuModel queryMenu = new MenuModel();
       queryMenu.setParentid(0L);
       List<MenuModel> menuList = menuMapper.menuList(queryMenu);
       List<MenuModel> tree = bulidTree(menuList);
       return  tree;
    }

    @Override
    public Menu saveMneu(Menu menu) {
        int count = menuMapper.insertSelective(menu);
        if(count > 0){
            return menu;
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteMneu(Long id) throws Exception {
        int count  = menuMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<MenuModel> chrildList(MenuModel menuModel) throws Exception {
        List<MenuModel> chrildList = getChrild(menuModel);
        return chrildList;
    }

    /**
     * 构造树
     * @param menuModelList
     * @return
     */
    private List<MenuModel> bulidTree(List<MenuModel> menuModelList){
        for(MenuModel m :menuModelList){
            List<MenuModel> nodes = getChrild(m);
            if(nodes!=null){
                m.setNodes(nodes);
                bulidTree(nodes);//递归调用
            }else{
                continue;
            }
        }
        return menuModelList;
    }

    /**
     * 得到子节点数据
     * @param menuModel
     * @return
     */
    private List<MenuModel> getChrild(MenuModel menuModel){
        MenuModel queryMenu = new MenuModel();
        queryMenu.setParentid(menuModel.getId());
        List<MenuModel> menuList = menuMapper.menuList(queryMenu);
        if(menuList != null &&menuList.size()>0){
            return menuList;
        }else {
            return null;
        }
    }


}
