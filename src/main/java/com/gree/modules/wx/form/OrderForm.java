package com.gree.modules.wx.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Map;

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
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     *
     */
    @ApiModelProperty(value = "商品映射（商品id，商品数量）",required = true)
    private Map<Long, Integer> goodsMap;
}
