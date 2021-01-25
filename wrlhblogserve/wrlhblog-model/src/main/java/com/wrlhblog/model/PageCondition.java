package com.wrlhblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCondition<T> {

    /**
     * 总数
     */
    private Long total;

    /**
     * 分页数据
     */
    private List<T> objList;


}
