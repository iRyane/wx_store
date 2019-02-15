package com.gree.modules.wx.service.impl;

import com.gree.modules.wx.entity.Goods;
import com.gree.modules.wx.service.GoodsService;
import com.gree.modules.wx.service.ShopCarService;
import com.gree.modules.wx.entity.ShopCar;
import com.gree.modules.wx.mapper.ShopCarMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ShopCarServiceImpl extends ServiceImpl<ShopCarMapper, ShopCar> implements ShopCarService {
    @Autowired
    private GoodsService goodsService;

    @Override
    public List<ShopCar> queryAll() {
        List<ShopCar> list = this.list();
        for(ShopCar shopCar : list){
            Goods goods = goodsService.getById(shopCar.getGoodsId());
            shopCar.setGoodsName(goods.getGoodsName());
            shopCar.setPrice(goods.getActualPrice());
            if(goods.getStock() > 0){
                shopCar.setStatus(1);
            }else {
                shopCar.setStatus(0);
            }
        }
        return list;
    }
}
