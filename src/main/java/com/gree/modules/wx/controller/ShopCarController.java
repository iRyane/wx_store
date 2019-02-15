package com.gree.modules.wx.controller;


import com.gree.common.utils.ResultUtil;
import com.gree.modules.wx.entity.ShopCar;
import com.gree.modules.wx.form.ShopCarForm;
import com.gree.modules.wx.service.ShopCarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
 * @since 2019-01-23
 */
@RestController
@RequestMapping("/wx/shopCar")
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    @ApiOperation(value = "添加商品到购物车")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ShopCarForm shopcarForm){
        ShopCar shopcar = new ShopCar();
        BeanUtils.copyProperties(shopcarForm, shopcar);
        shopCarService.save(shopcar);
        return ResultUtil.success(HttpStatus.CREATED);
    }

    @ApiOperation(value = "查看购物车内商品")
    @GetMapping("/list")
    public ResponseEntity list(){
        List<ShopCar> list = shopCarService.queryAll();
        return ResultUtil.success(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete (@RequestParam Long id){
        shopCarService.removeById(id);
        return ResultUtil.success(HttpStatus.NO_CONTENT);
    }
}
