package com.wrlhblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrlhblog.mapper.MenuMapper;
import com.wrlhblog.model.Menu;
import com.wrlhblog.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuByUserId(Long id) {
        return menuMapper.getMenuByUserId(id);
    }
}
