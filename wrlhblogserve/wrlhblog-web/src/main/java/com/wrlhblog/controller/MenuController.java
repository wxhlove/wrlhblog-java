package com.wrlhblog.controller;


import com.wrlhblog.model.Menu;
import com.wrlhblog.service.IMenuService;
import com.wrlhblog.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;


    /**
     * 通过当前登录用户的id 获取到相应的菜单权限
     *
     * @return
     */
    @GetMapping("/")
    public List<Menu> getMenuByUserId() {
        return iMenuService.getMenuByUserId(UserInfoUtil.getUser().getId());
    }


}
