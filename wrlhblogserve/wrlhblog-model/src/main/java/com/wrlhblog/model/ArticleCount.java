package com.wrlhblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章点赞计数表
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleCount implements Serializable {

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
     * 文章点赞计数
     */
    private Integer countNumber;

    /**
     * 计数时间
     */
    private Date countTime;


}
