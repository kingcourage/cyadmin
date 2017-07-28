package com.wcy;

import com.wcy.service.core.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by wcy on 2017/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMenu {
    @Autowired
    MenuService menuService;

    @Test
    public void change(){
        menuService.changeMenu();
    }
}
