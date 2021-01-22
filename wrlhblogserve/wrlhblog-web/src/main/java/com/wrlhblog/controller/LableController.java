package com.wrlhblog.controller;


import com.wrlhblog.model.Lable;
import com.wrlhblog.service.ILableService;
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
@RequestMapping("/lable")
public class LableController {

    @Autowired
    private ILableService iLableService;


    /**
     * 查询所有标签
     *
     * @return
     */
    @GetMapping("/")
    public List<Lable> getLables() {
        return iLableService.getLables();
    }

    /**
     * 添加标签
     *
     * @return
     */
    @PostMapping("/")
    public RespBean addLable(@RequestBody Lable lable) {
        int i = iLableService.addLable(lable);
        if (i == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }


}
