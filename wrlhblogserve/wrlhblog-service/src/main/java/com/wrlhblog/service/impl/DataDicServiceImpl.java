package com.wrlhblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrlhblog.mapper.DataDicMapper;
import com.wrlhblog.model.DataDic;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.service.IDataDicService;
import com.wrlhblog.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataDicServiceImpl extends ServiceImpl<DataDicMapper, DataDic> implements IDataDicService {

    @Autowired
    private DataDicMapper dataDicMapper;


    @Override
    public PageCondition<DataDic> getDataDirs(Integer currentPage, Integer pageSize) {

        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = Integer.MAX_VALUE;
        }

        Page<DataDic> page = new Page<DataDic>(currentPage, pageSize);

        IPage<DataDic> pageContent = dataDicMapper.getDataDirs(page, UserInfoUtil.getUser().getId());

        return new PageCondition<DataDic>(pageContent.getTotal(), pageContent.getRecords());


    }

    @Override
    public int updateDataDic(DataDic dataDic) {

        DataDic dataDic1 = new DataDic();
        dataDic1.setId(dataDic.getId());
        dataDic1.setDataContent(dataDic.getDataContent());
        dataDic1.setCreateTime(dataDic.getCreateTime());
        dataDic1.setUpdateTime(new Date());
        return dataDicMapper.updateById(dataDic1);
    }
}
