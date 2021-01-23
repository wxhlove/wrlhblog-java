package com.wrlhblog.mapper;

import com.wrlhblog.model.Sort;
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
public interface SortMapper extends BaseMapper<Sort> {

    /**
     * 查询分类列表
     *
     * @param id
     * @return
     */
    List<Sort> getSorts(@Param("id") Long id);
}
