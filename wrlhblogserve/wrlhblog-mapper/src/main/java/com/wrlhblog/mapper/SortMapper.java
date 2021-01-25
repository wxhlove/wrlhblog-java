package com.wrlhblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrlhblog.model.Sort;
import com.wrlhblog.model.SortOrLableSearchCondition;
import org.apache.ibatis.annotations.Param;

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
     * @param solsearchcondition
     * @param page
     * @param id
     * @return
     */
    IPage<Sort> getSorts(Page<Sort> page, @Param("id") Long id, @Param("solSearchCondition") SortOrLableSearchCondition solSearchCondition);

    Sort getSortByname(@Param("name") String name);
}
