package com.wrlhblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrlhblog.model.Lable;
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
public interface LableMapper extends BaseMapper<Lable> {

    IPage<Lable> getLables(Page<Lable> page, @Param("id") Long id, @Param("solSearchCondition") SortOrLableSearchCondition solSearchCondition);

    Lable getLableByName(@Param("name") String name);

}
