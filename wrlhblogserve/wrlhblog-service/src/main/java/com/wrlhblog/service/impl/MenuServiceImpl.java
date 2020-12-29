package com.wrlhblog.service.impl;

import com.wrlhblog.model.Menu;
import com.wrlhblog.mapper.MenuMapper;
import com.wrlhblog.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
