package com.wrlhblog.service;

import com.wrlhblog.model.Sort;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
public interface ISortService extends IService<Sort> {

    List<Sort> getSorts();

    int addSort(Sort sort);
}
