package com.wcy.adminapi.controller;

import com.wcy.adminapi.common.ZTreeModel;
import com.wcy.adminapi.model.Resource;
import com.wcy.adminapi.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/resource/")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("index")
    public String index(){
        return "admin/resource";
    }


    @ResponseBody
    @RequestMapping("tree_data")
    public List treeData(@RequestParam(defaultValue = "0") Long parentId){
       List<Resource> resourceList =  resourceService.getResourceByParentId(parentId);
       List<ZTreeModel> zTreeModelList = resourceList.stream().map(item->new ZTreeModel(item)).collect(Collectors.toList());
       return  zTreeModelList;
    }
}
