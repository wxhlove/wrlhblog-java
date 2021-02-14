package com.wrlhblog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class DataDic implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Long id;


    /**
     * 用户id
     */
    private Long uid;
    /**
     * 字典代码
     */
    private String dicCode;

    /**
     * 字典名称
     */
    private String dicName;

    /**
     * 描述
     */
    private String describe;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private Boolean state;

    /**
     * 单位
     */
    private String company;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据内容
     */
    private String dataContent;


}



