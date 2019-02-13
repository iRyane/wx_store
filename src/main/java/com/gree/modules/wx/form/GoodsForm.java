package com.gree.modules.wx.form;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 实际价格
     */
    private BigDecimal actualPrice;

    /**
     * 商品简介
     */
    private String description;

    /**
     * 库存
     */
    private Integer stock;

}
