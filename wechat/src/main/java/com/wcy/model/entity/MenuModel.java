package com.wcy.model.entity;

import java.util.List;

public class MenuModel extends Menu{
    public List<MenuModel> getNodes() {
        return nodes;
    }

    public void setNodes(List<MenuModel> nodes) {
        this.nodes = nodes;
    }

    private List<MenuModel> nodes;

}
