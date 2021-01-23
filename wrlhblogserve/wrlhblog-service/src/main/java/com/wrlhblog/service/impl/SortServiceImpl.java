package com.wrlhblog.service.impl;

import com.wrlhblog.model.Sort;
import com.wrlhblog.mapper.SortMapper;
import com.wrlhblog.model.User;
import com.wrlhblog.service.ISortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrlhblog.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
     * @return
     */
    @Override
    public List<Sort> getSorts() {
        return sortMapper.getSorts(UserInfoUtil.getUser().getId());
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
}
