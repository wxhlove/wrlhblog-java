package com.wrlhblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

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
     * 模块所在文件夹
     */
    private String componentDir;

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
     * 是否需要登录显示
     */
    private Boolean requireAuth;

    /**
     * 父级id
     */
    private Long parentId;


    /**
     * 当前是否是父级目录(0不是 ， 1是)
     */
    private Boolean parentIs;


    /**
     * 是否是父级目录
     */
    private Boolean enabled;

    /**
     * meta附加选项
     */
    private Meta meta;

    /**
     * 菜单子选项
     */
    private List<Menu> children;


}
