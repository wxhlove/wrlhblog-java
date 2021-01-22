package com.wrlhblog.mapper;

import com.wrlhblog.model.Lable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
public interface LableMapper extends BaseMapper<Lable> {

    List<Lable> getLables(@Param("id") Long id);
}
