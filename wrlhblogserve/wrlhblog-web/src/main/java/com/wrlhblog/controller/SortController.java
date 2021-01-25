package com.wrlhblog.controller;


import com.alibaba.druid.util.StringUtils;
import com.wrlhblog.model.PageCondition;
import com.wrlhblog.model.Sort;
import com.wrlhblog.model.SortOrLableSearchCondition;
import com.wrlhblog.service.ISortService;
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
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private ISortService iSortService;


    /**
     * 查询分类列表
     *
     * @return
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public PageCondition<Sort> getSorts(@PathVariable(value = "currentPage", required = false) Integer currentPage,
                                  @PathVariable(value = "pageSize", required = false) Integer pageSize,
                                  @RequestParam(required = false) String sortName,
                                  @RequestParam(required = false) String startTime,
                                  @RequestParam(required = false) String endTime) {
        SortOrLableSearchCondition solSearchCondition = new SortOrLableSearchCondition();
        solSearchCondition.setSortName(StringUtils.isEmpty(sortName) ? "" : sortName.trim());
        solSearchCondition.setStartTime(StringUtils.isEmpty(startTime) ? "" : startTime + " 00:00:00");
        solSearchCondition.setEndTime(StringUtils.isEmpty(endTime) ? "" : endTime + " 23:59:59");
        return iSortService.getSorts(currentPage, pageSize, solSearchCondition);
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

    /**
     * 更新分类
     *
     * @param sort
     * @return
     */
    @PutMapping("/")
    public RespBean updateSort(@RequestBody Sort sort) {
        int i = iSortService.updateSort(sort);
        if (1 == i) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSort(@PathVariable(value = "id", required = true) Long id) {
        int i = iSortService.deleteSort(id);
        if (1 == i) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }


    /**
     * 根据分类名称查询分类信息
     *
     * @return
     */
    @GetMapping("/check/{name}")
    public Sort getSortByname(@PathVariable(value = "name", required = true) String name) {
        return iSortService.getSortByname(name.trim());
    }

}
