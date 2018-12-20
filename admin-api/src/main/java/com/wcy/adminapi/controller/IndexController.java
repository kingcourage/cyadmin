package com.wcy.adminapi.controller;

import com.wcy.adminapi.common.Dict;
import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.model.UserDetailsImpl;
import com.wcy.adminapi.model.vo.MenuVO;
import com.wcy.adminapi.service.ResourceService;
import com.wcy.adminapi.util.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/admin/index")
    public String index(HttpSession session){
       UserDetailsImpl userDetails =  SecurityUtil.getCurrentUser();
       List<Resource> menus =  resourceService.getResourceByUserIdAndType(userDetails.getId(),Dict.ResourceTyep.MENU.getCode());
       List<MenuVO> menuVOList = menus.stream().filter(item->item.getParentId() == 0).map(item->{
           MenuVO menuVO = new MenuVO();
           BeanUtils.copyProperties(item,menuVO);
           return menuVO;
       }).collect(Collectors.toList());
       menuVOList.stream().forEach(item->{
           for(Resource menu : menus){
               if(menu.getParentId().equals(item.getId())){
                   MenuVO menuVO = new MenuVO();
                   BeanUtils.copyProperties(menu,menuVO);
                   if(item.getChildren() == null){
                       ArrayList arrayList = new ArrayList();
                       arrayList.add(menuVO);
                       item.setChildren(arrayList);
                   }else{
                       item.getChildren().add(menuVO);
                   }

               }
           }
       });
       session.setAttribute("menus",menuVOList);
       return "admin/index";
    }
}
