package com.gree.modules.wx.controller;


import com.gree.common.utils.ResultUtil;
import com.gree.modules.wx.form.OrderForm;
import com.gree.modules.wx.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yan
 * @since 2019-01-23
 */
@RestController
@RequestMapping("/wx/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "生成订单")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody OrderForm orderForm){
        orderService.add(orderForm);
        return ResultUtil.success(HttpStatus.CREATED);
    }

}
