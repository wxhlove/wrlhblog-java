package com.wrlhblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrlhblog.mapper.SortMapper;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.model.Sort;
import com.wrlhblog.model.SortOrLableSearchCondition;
import com.wrlhblog.model.User;
import com.wrlhblog.service.ISortService;
import com.wrlhblog.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
@Service
public class SortServiceImpl extends ServiceImpl<SortMapper, Sort> implements ISortService {


    @Autowired
    private SortMapper sortMapper;

    /**
     * 查询分类列表
     *
     * @param currentPage
     * @param pageSize
     * @param solSearchCondition
     * @return
     */
    @Override
    public PageCondition<Sort> getSorts(Integer currentPage, Integer pageSize, SortOrLableSearchCondition solSearchCondition) {
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = Integer.MAX_VALUE;
        }
        Page<Sort> page = new Page<Sort>(currentPage, pageSize);
        IPage<Sort> iPage = sortMapper.getSorts(page, UserInfoUtil.getUser().getId(), solSearchCondition);
        return new PageCondition<Sort>(iPage.getTotal(), iPage.getRecords());
    }

    /**
     * 添加分类
     *
     * @param sort
     * @return
     */
    @Override
    public int addSort(Sort sort) {
        User user = UserInfoUtil.getUser();
        sort.setAddTime(new Date());
        sort.setAddUsername(user.getUsername());
        sort.setUid(user.getId());
        return sortMapper.insert(sort);
    }

    @Override
    public int updateSort(Sort sort) {
        return sortMapper.updateById(sort);
    }

    @Override
    public int deleteSort(Long id) {
        return sortMapper.deleteById(id);
    }

    @Override
    public Sort getSortByname(String name) {
        return sortMapper.getSortByname(name);
    }
}
