package com.gree.modules.wx.service;

import com.gree.modules.wx.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gree.modules.wx.form.OrderForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2019-01-23
 */
public interface OrderService extends IService<Order> {

    /**
     * 生成订单
     * @param orderForm
     * @return
     */
    boolean add(OrderForm orderForm);
}
