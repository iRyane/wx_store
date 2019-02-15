package com.gree.modules.wx.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopCarForm {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer number;
}
