package com.gree.modules.wx.service.impl;

import com.gree.modules.wx.entity.User;
import com.gree.modules.wx.mapper.UserMapper;
import com.gree.modules.wx.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
