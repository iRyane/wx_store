package com.gree.modules.wx.service;

import com.gree.modules.wx.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
public interface GoodsService extends IService<Goods> {

	int add(Goods goods);

	List<Goods> queryAll();

	Goods query(Long goodsId);
}
