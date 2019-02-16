package com.gree.modules.wx.controller;

import com.gree.modules.wx.entity.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected User getUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId(){
        return getUser().getId();
    }
}
