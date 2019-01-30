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

import java.util.List;
import java.util.Map;

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

		int num = 1000 + (int)(Math.random() * 9000);
 		String code = "SP" + DateUtils.getCurrentDataString() + num;
 		goods.setCode(code);

	    return baseMapper.insert(goods);
	}

	@Override
	public List<Goods> queryAll() {
		return baseMapper.list();
	}

	@Override
	public Goods query(Long goodsId){
		Goods goods = baseMapper.selectById(goodsId);
		List<Map<String,Object>> list = goodsPictureService.listMaps(new QueryWrapper<GoodsPicture>().eq("goods_id",goodsId));

		return goods;
	}
}
