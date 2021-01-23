package com.wrlhblog.controller;


import com.wrlhblog.model.Sort;
import com.wrlhblog.service.ISortService;
import com.wrlhblog.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
@RestController
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private ISortService iSortService;


    /**
     * 查询分类列表
     *
     * @return
     */
    @GetMapping("/")
    public List<Sort> getSorts() {
        return iSortService.getSorts();
    }


    /**
     * 添加分类
     *
     * @param sort
     * @return
     */
    @PostMapping("/")
    public RespBean addSort(@RequestBody Sort sort) {

        int i = iSortService.addSort(sort);
        if (i == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }


}
