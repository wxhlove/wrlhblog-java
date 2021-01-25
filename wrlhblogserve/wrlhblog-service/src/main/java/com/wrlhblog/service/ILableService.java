package com.wrlhblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrlhblog.model.Lable;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.model.SortOrLableSearchCondition;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
public interface ILableService extends IService<Lable> {

    int addLable(Lable lable);

    PageCondition<Lable> getLables(Integer currentPage, Integer pageSize, SortOrLableSearchCondition solSearchCondition);

    int updateLable(Lable lable);

    int deleteLable(Long id);

    Lable getLableByName(String name);

}
