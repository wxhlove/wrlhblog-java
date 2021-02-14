package com.wrlhblog.controller;

import com.wrlhblog.model.DataDic;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.service.IDataDicService;
import com.wrlhblog.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 操作数据库字典
 * <p>
 * 1、不允许从页面添加数据字典
 * 2、修改出具库字典只允许修改数据字典的部分字段值
 * 3、不允许通过页面删除数据库字段
 */
@RestController
@RequestMapping("/dataDic")
public class DataDirController {

    @Autowired
    private IDataDicService iDataDicService;


    /**
     * 带条件查询数据字典内容
     */
    @GetMapping(value = {"/", "/{currentPage}/{pageSize}"})
    public PageCondition<DataDic> getDataDirs(@PathVariable(value = "currentPage", required = false) Integer currentPage,
                                              @PathVariable(value = "pageSize", required = false) Integer pageSize) {


        return iDataDicService.getDataDirs(currentPage, pageSize);
    }


    /**
     * 修改数据库字典
     *
     * @return
     */
    @PutMapping("/")
    public RespBean updateDataDic(@RequestBody DataDic dataDic) {
        int i = iDataDicService.updateDataDic(dataDic);
        if (1 == i) {
            return RespBean.ok("修改字典成功");
        }
        return RespBean.error("修改字典失败");
    }

}
