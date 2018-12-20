package com.wcy.adminapi.common;


import com.wcy.adminapi.model.Resource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class ZTreeModel {
    private Long id;

    private Long pId;

    private String name;

    private List<ZTreeModel> children;

    private boolean isParent = true;

    private String checked;

    private String icon;

    private String url_address;

    public boolean getIsParent() {
        return isParent;
    }

    public ZTreeModel(Resource resource) {
        this.id  = resource.getId();
        this.pId = resource.getParentId();
        this.name = resource.getName();
        this.icon = resource.getIcon();
        this.url_address = resource.getUrl();
    }


}
