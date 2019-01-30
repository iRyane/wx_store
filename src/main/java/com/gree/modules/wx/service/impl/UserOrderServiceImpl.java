package com.gree.modules.wx.service.impl;

import com.gree.modules.wx.entity.UserOrder;
import com.gree.modules.wx.mapper.UserOrderMapper;
import com.gree.modules.wx.service.UserOrderService;
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
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

}
