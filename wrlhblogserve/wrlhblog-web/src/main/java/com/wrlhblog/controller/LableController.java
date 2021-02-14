package com.wrlhblog.controller;


import com.alibaba.druid.util.StringUtils;
import com.wrlhblog.model.Lable;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.model.SortOrLableSearchCondition;
import com.wrlhblog.service.ILableService;
import com.wrlhblog.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = {"/{currentPage}/{pageSize}", "/"})
    public PageCondition<Lable> getLables(@PathVariable(value = "currentPage", required = false) Integer currentPage,
                                          @PathVariable(value = "pageSize", required = false) Integer pageSize,
                                          @RequestParam(required = false) String lableName,
                                          @RequestParam(required = false) String startTime,
                                          @RequestParam(required = false) String endTime) {
        SortOrLableSearchCondition solSearchCondition = new SortOrLableSearchCondition();
        solSearchCondition.setLableName(StringUtils.isEmpty(lableName) ? "" : lableName.trim());
        solSearchCondition.setStartTime(StringUtils.isEmpty(startTime) ? "" : startTime + " 00:00:00");
        solSearchCondition.setEndTime(StringUtils.isEmpty(endTime) ? "" : endTime + " 23:59:59");


        return iLableService.getLables(currentPage, pageSize, solSearchCondition);
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

    @PutMapping("/")
    public RespBean updateLable(@RequestBody Lable lable) {
        int i = iLableService.updateLable(lable);
        if (i == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteLable(@PathVariable(value = "id", required = true) Long id) {
        int i = iLableService.deleteLable(id);
        if (1 == i) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @GetMapping("/check/{name}")
    public Lable getLableByName(@PathVariable(value = "name", required = true) String name) {
        return iLableService.getLableByName(name.trim());
    }

}
