package com.gree.modules.wx.service;

import com.gree.modules.wx.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2019-01-23
 */
public interface OrderService extends IService<Order> {

    int add(Order order);
}
