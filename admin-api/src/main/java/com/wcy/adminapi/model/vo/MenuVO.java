package com.wcy.adminapi.model.vo;

import com.wcy.adminapi.model.Resource;
import lombok.Data;

import java.util.List;

@Data
public class MenuVO extends Resource {
    List<MenuVO> children;
}
