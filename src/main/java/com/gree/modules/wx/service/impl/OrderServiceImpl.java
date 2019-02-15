package com.gree.modules.wx.service.impl;

import com.gree.common.utils.DateUtils;
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

    @Override
    public int add(Order order) {

        //根据时间和四位随机数自动生成商品编码
        int num = 100000 + (int)(Math.random() * 900000);
        String code = "DD" + DateUtils.getCurrentDataString() + num;
        order.setCode(code);
        order.setStatus(0);

        return baseMapper.insert(order);
    }
}
