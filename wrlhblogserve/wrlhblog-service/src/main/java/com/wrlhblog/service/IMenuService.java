package com.wrlhblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrlhblog.model.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
public interface IMenuService extends IService<Menu> {


    /**
     * 根据用户id 获取相应的菜单权限
     *
     * @param id
     * @return
     */
    List<Menu> getMenuByUserId(Long id);
}
