package com.wrlhblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrlhblog.model.DataDic;
import com.wrlhblog.model.PageCondition;

public interface IDataDicService extends IService<DataDic> {
    PageCondition<DataDic> getDataDirs(Integer currentPage, Integer pageSize);

    int updateDataDic(DataDic dataDic);
}
