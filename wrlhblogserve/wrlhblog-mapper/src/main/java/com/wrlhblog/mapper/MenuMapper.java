package com.wrlhblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrlhblog.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
public interface MenuMapper extends BaseMapper<Menu> {


    public List<Menu>  getMenuByUserId(@Param("id") Long id);


}
