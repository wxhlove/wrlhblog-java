package com.wrlhblog.service;

import com.wrlhblog.model.PageCondition;
import com.wrlhblog.model.Sort;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrlhblog.model.SortOrLableSearchCondition;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
public interface ISortService extends IService<Sort> {

    PageCondition<Sort> getSorts(Integer currentPage, Integer pageSize, SortOrLableSearchCondition solSearchCondition);

    int addSort(Sort sort);

    int updateSort(Sort sort);

    int deleteSort(Long id);

    Sort getSortByname(String name);
}
