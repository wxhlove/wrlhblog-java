package com.wrlhblog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Lable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;


    /**
     * 用户id
     */
    private Long uid;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 别名
     */
    private String nameStyleColor;

    /**
     * 描述
     */
    private String descripation;

    /**
     * 添加人姓名
     */
    private String addUsername;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 标签和分类样式主题颜色
     */
    @TableField(exist = false)
    private NameColor nameColor;

    public String getNameStyleColor() {
        return nameStyleColor;
    }

    public void setNameStyleColor(String nameStyleColor) {

        NameColor nameColor = new NameColor();
        nameColor.setBorderColor(nameStyleColor);
        nameColor.setColor(nameStyleColor);
        this.nameColor = nameColor;

        this.nameStyleColor = nameStyleColor;
    }

    public NameColor getNameColor() {
        return nameColor;
    }

    public void setNameColor(NameColor nameColor) {
        this.nameColor = nameColor;
    }
}
