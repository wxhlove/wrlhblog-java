package com.wrlhblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    private Long aid;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 评论时间
     */
    private Date commentTime;


}
