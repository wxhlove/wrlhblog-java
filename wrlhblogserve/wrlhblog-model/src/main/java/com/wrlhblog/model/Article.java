package com.wrlhblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 分类id
     */
    private Long sid;

    /**
     * 标签id
     */
    private Long lid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * md文件源码/富文本源码
     */
    private String articleContent;

    /**
     * 编辑模式(markdown /富文本)
     */
    private String editModel;

    /**
     * 总结
     */
    private String summary;

    /**
     * 发布日期
     */
    private Date publishTime;

    /**
     * 编辑日期
     */
    private Date editTime;

    /**
     * 0表示草稿箱，1表示已发表，2表示已删除
     */
    private Integer state;

    /**
     * 总结背景图片
     */
    private String imageUrl;


}
