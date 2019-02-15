package com.gree.modules.wx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
 * @since 2019-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_shopcar")
public class ShopCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 商品ID
     */
    @TableField("goods_id")
    private Long goodsId;

    /**
     * 商品名
     */
    @TableField(exist = false)
    private String goodsName;

    /**
     * 实际价格
     */
    @TableField(exist = false)
    private BigDecimal price;

    /**
     * 商品数量
     */
    @TableField("number")
    private Integer number;

    /**
     * 记录状态  1、正常  0、禁用
     */
    @TableField("status")
    private Integer status;

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


}
