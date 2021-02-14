package com.wrlhblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wrlhblog.model.DataDic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDicMapper extends BaseMapper<DataDic> {
    IPage<DataDic> getDataDirs(@Param("page") IPage<DataDic> page, @Param("uid") Long uid);



    List<DataDic> getDataDirs(@Param("uid") Long uid);
}
