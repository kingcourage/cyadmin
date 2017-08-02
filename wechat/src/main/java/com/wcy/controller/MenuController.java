package com.wcy.controller;

import com.wcy.model.PageResponse;
import com.wcy.model.entity.BaseModel;
import com.wcy.model.entity.Menu;
import com.wcy.model.entity.MenuModel;
import com.wcy.service.MenuService;
import com.wcy.util.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String menu(){
        return "menu";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public PageResponse menuList(HttpServletRequest request){
        List<MenuModel> menuModelList = null;
        try {
            menuModelList = menuService.menuList(null);
            pageResponse.setData(menuModelList);
            pageResponse.setCode(Dict.ReturnCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResponse;
    }

    @RequestMapping(value = "/add")
    public String addMenu(Long parentid,HttpServletRequest request){
        request.setAttribute("parentid",parentid);
        return "addmenu";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public PageResponse saveMenu(Menu menu){
        try {
            menu = menuService.saveMneu(menu);
            if(menu == null){
                pageResponse.setCode(Dict.ReturnCode.FAIL);
            }else{
                pageResponse.setCode(Dict.ReturnCode.SUCCESS);
                pageResponse.setData(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public PageResponse deleteMenu(Long id){
        try {
          boolean flag = menuService.deleteMneu(id);
          if(flag){
              pageResponse.setCode(Dict.ReturnCode.SUCCESS);
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/chrild")
    public PageResponse chrild(Long parentid){
        MenuModel menuModel = new MenuModel();
        if(parentid == null){
            parentid = 0L;
        }
        menuModel.setId(parentid);
        try {
            List<MenuModel> menuModelList = menuService.chrildList(menuModel);
            pageResponse.setCode(Dict.ReturnCode.SUCCESS);
            pageResponse.setData(menuModelList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResponse;
    }
}
