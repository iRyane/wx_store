package com.gree.modules.wx.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderForm {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 收货地址ID
     */
    private Long addressId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 价格
     */
    private BigDecimal price;
}
