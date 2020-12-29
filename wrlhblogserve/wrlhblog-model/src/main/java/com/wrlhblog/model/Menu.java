package com.wrlhblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * url地址
     */
    private String url;

    /**
     * path地址
     */
    private String path;

    /**
     * 模块名称
     */
    private String component;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标样式
     */
    private String iconCls;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 是否是父级目录
     */
    private Boolean enabled;


}
