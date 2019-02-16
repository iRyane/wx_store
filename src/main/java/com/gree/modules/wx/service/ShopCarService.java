package com.gree.modules.wx.service;

import com.gree.modules.wx.entity.ShopCar;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2019-01-23
 */
public interface ShopCarService extends IService<ShopCar> {

    /**
     * 查看购物车内商品
     * @return
     */
    List<ShopCar> queryAll(Long userId);

    int deleteBatch(List<Long> goodsId);

}
