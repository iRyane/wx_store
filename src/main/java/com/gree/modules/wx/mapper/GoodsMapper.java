package com.gree.modules.wx.mapper;

import com.gree.modules.wx.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

	List<Goods> list();
}
