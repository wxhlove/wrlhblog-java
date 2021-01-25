package com.wrlhblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrlhblog.model.Lable;
import com.wrlhblog.mapper.LableMapper;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.model.SortOrLableSearchCondition;
import com.wrlhblog.model.User;
import com.wrlhblog.service.ILableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class LableServiceImpl extends ServiceImpl<LableMapper, Lable> implements ILableService {

    @Autowired
    private LableMapper lableMapper;

    @Override
    public int addLable(Lable lable) {
        User user = UserInfoUtil.getUser();
        lable.setUid(user.getId());
        lable.setAddTime(new Date());
        lable.setAddUsername(user.getUsername());
        return lableMapper.insert(lable);
    }

    @Override
    public PageCondition<Lable> getLables(Integer currentPage, Integer pageSize, SortOrLableSearchCondition solSearchCondition) {
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = Integer.MAX_VALUE;
        }
        Page page = new Page<Lable>(currentPage, pageSize);
        IPage lables = lableMapper.getLables(page, UserInfoUtil.getUser().getId(), solSearchCondition);
        return new PageCondition<Lable>(lables.getTotal(), lables.getRecords());
    }

    @Override
    public int updateLable(Lable lable) {
        return lableMapper.updateById(lable);
    }

    @Override
    public int deleteLable(Long id) {
        return lableMapper.deleteById(id);
    }

    @Override
    public Lable getLableByName(String name) {
        return lableMapper.getLableByName(name);
    }
}
