package com.gree.modules.wx.service.impl;

import com.gree.modules.wx.entity.LogEntity;
import com.gree.modules.wx.mapper.LogMapper;
import com.gree.modules.wx.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements LogService {

}
