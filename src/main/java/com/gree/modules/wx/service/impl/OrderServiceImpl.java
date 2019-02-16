package com.gree.modules.wx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gree.common.utils.DateUtils;
import com.gree.modules.wx.entity.GoodsOrder;
import com.gree.modules.wx.entity.Order;
import com.gree.modules.wx.entity.ShopCar;
import com.gree.modules.wx.form.OrderForm;
import com.gree.modules.wx.mapper.OrderMapper;
import com.gree.modules.wx.service.GoodsOrderService;
import com.gree.modules.wx.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gree.modules.wx.service.ShopCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private ShopCarService shopCarService;

    @Override
    @Transactional
    public boolean add(OrderForm orderForm) {
        Order order = new Order();
        //根据时间和四位随机数自动生成商品编码
        int num = 100000 + (int)(Math.random() * 900000);
        String code = "DD" + DateUtils.getCurrentDataString() + num;
        order.setCode(code);
        order.setStatus(0);
        order.setAddressId(orderForm.getAddressId());
        order.setTotalPrice(orderForm.getTotalPrice());
        baseMapper.insert(order);

        //商品ID
        List<Long> goodsIdList = new ArrayList<>();
        //保存订单与商品关联关系
        List<GoodsOrder> list = new ArrayList<>();
        for(Long goodsId : orderForm.getGoodsMap().keySet()){
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setOrderId(order.getId());
            goodsOrder.setNumber(orderForm.getGoodsMap().get(goodsId));
            list.add(goodsOrder);
            goodsIdList.add(goodsId);
        }
        Boolean flag = goodsOrderService.saveBatch(list);

        shopCarService.deleteBatch(goodsIdList);

        return flag;
    }
}
