package com.gree.modules.wx.service.impl;

import com.gree.modules.wx.entity.GoodsPicture;
import com.gree.modules.wx.mapper.GoodsPictureMapper;
import com.gree.modules.wx.service.GoodsPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Service
public class GoodsPictureServiceImpl extends ServiceImpl<GoodsPictureMapper, GoodsPicture> implements GoodsPictureService {

    @Override
    public List<String> query(Long goodsId) {
//        Map map = new HashMap();
//        map.put("goods_id", goodsId);
//        baseMapper.selectByMap(map);
        return baseMapper.query(goodsId);
    }
}
