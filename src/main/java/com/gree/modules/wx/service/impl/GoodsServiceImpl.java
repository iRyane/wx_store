package com.gree.modules.wx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gree.common.utils.DateUtils;
import com.gree.modules.wx.entity.Goods;
import com.gree.modules.wx.entity.GoodsPicture;
import com.gree.modules.wx.mapper.GoodsMapper;
import com.gree.modules.wx.service.GoodsPictureService;
import com.gree.modules.wx.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
	@Autowired
	private GoodsPictureService goodsPictureService;

	@Override
	public int add(Goods goods){
		
		//根据时间和四位随机数自动生成商品编码
		int num = 1000 + (int)(Math.random() * 9000);
 		String code = "SP" + DateUtils.getCurrentDataString() + num;
 		goods.setCode(code);

	    return baseMapper.insert(goods);
	}

	@Override
	public List<Goods> queryAll() {
		List<Goods> list = this.list();
		for(Goods good : list){
			List<String> pictures = goodsPictureService.query(good.getId());
			good.setPicture(pictures);
		}
		return list;
	}

	@Override
	public Goods query(Long goodsId){
		Goods goods = baseMapper.selectById(goodsId);
		List<String> pictures = goodsPictureService.query(goodsId);
		goods.setPicture(pictures);

		return goods;
	}
}
