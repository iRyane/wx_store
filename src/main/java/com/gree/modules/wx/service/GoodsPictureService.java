package com.gree.modules.wx.service;

import com.gree.modules.wx.entity.GoodsPicture;
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
public interface GoodsPictureService extends IService<GoodsPicture> {

    /**
     * 根据物品Id查询物品图片
     * @param goodsId
     * @return
     */
    List<String> query(Long goodsId);

}
