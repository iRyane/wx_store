package com.gree.modules.wx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gree.common.utils.ResultUtil;
import com.gree.modules.wx.entity.Address;
import com.gree.modules.wx.service.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/wx/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "添加收货地址")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Address address){
        addressService.save(address);
        return ResultUtil.success(address,HttpStatus.CREATED);
    }

    @ApiOperation(value = "查看用户收货地址")
    @GetMapping("/list")
    public ResponseEntity list(@RequestParam Long userId){
        List<Address> list = addressService.list(new QueryWrapper<Address>().eq("user_id", userId));
        return ResultUtil.success(list, HttpStatus.OK);
    }

    @ApiOperation(value = "删除收货地址")
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id){
        addressService.removeById(id);
        return ResultUtil.success(HttpStatus.NO_CONTENT);
    }
}
