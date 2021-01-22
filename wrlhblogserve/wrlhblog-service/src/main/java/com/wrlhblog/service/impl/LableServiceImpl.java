package com.wrlhblog.service.impl;

import com.wrlhblog.model.Lable;
import com.wrlhblog.mapper.LableMapper;
import com.wrlhblog.model.User;
import com.wrlhblog.service.ILableService;
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
    public List<Lable> getLables() {
        return lableMapper.getLables(UserInfoUtil.getUser().getId());

    }
}
