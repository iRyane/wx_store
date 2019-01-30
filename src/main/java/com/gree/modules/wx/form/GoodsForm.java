package com.gree.modules.wx.form;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsForm implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @TableField(exist = false)
    private List<String> picture;
}
