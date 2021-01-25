package com.wrlhblog.model;

import lombok.Data;

@Data
public class SortOrLableSearchCondition {

    /**
     * 分类名称
     */
    private String sortName;

    /**
     * 标签名称
     */
    private String lableName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;


}
