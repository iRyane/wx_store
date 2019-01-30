package com.gree.modules.wx.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    /**
     * 商品编号
     */
    @TableField("code")
    private String code;

    /**
     * 商品名
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 原价
     */
    @TableField("original_price")
    private BigDecimal originalPrice;

    /**
     * 实际价格
     */
    @TableField("actual_price")
    private BigDecimal actualPrice;

    /**
     * 商品简介
     */
    @TableField("description")
    private String description;

    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 创建者ID
     */
    @TableField("create_user_id")
    @JsonIgnore
    private Long createUserId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonIgnore
    private LocalDateTime createTime;

    @TableField(exist = false)
    private List<String> picture;

}
