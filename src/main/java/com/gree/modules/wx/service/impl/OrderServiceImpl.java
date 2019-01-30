package com.gree.modules.wx.service.impl;

import com.gree.modules.wx.entity.Order;
import com.gree.modules.wx.mapper.OrderMapper;
import com.gree.modules.wx.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2019-01-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
