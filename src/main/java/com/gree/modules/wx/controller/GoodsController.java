package com.gree.modules.wx.controller;


import com.gree.common.exception.RRException;
import com.gree.common.utils.FileUtil;
import com.gree.common.utils.ResultUtil;
import com.gree.modules.wx.entity.Goods;
import com.gree.modules.wx.entity.GoodsPicture;
import com.gree.modules.wx.form.GoodsForm;
import com.gree.modules.wx.service.GoodsPictureService;
import com.gree.modules.wx.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Api("商品")
@RestController
@RequestMapping("/wx/goods")
public class GoodsController {
    @Value("${com.servicePort}")
    private String port; //主机端口
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsPictureService goodsPictureService;

    @ApiOperation(value = "查询商品列表")
    @GetMapping("/list")
    public ResponseEntity list(){
        List<Goods> list = goodsService.queryAll();
        return ResultUtil.success(list, HttpStatus.OK);
    }

    @ApiOperation(value = "通过Id查询商品信息")
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id){
        Goods goods = goodsService.query(id);
        return  ResultUtil.success(goods, HttpStatus.OK);
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody GoodsForm goodsForm){
        Goods goods = new Goods();
        BeanUtils.copyProperties(goods, goodsForm);
        goodsService.add(goods);
        return ResultUtil.success(goods,HttpStatus.CREATED);
    }

    @ApiOperation(value = "上传商品图片")
    @PostMapping("/uploadImg")
    public ResponseEntity uploadImg(@RequestParam("goodsId")Long goodsId, @RequestParam("file") MultipartFile file) throws Exception {

        String filePath = "E:/Develop/Files/Photos";  //图片存放路径
        String fileName = file.getOriginalFilename();  //图片名

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            throw new RRException("图片上传失败！");
        }

        //获取本机IP
        String host = "localhost";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("get server host Exception e:", e);
        }

        String imgPath = (host + ":" + port + "/Develop/Files/Photos/" + fileName).toString();
        GoodsPicture goodsPicture = new GoodsPicture();
        goodsPicture.setGoodsId(goodsId);
        goodsPicture.setPicture(imgPath);
        goodsPictureService.save(goodsPicture);

        return ResultUtil.success(HttpStatus.CREATED);

    }

    @ApiOperation(value = "获取首页图片")
    @GetMapping("/getImg")
    public ResponseEntity getImg(){
        List<String> list = goodsPictureService.query(0L);
        return ResultUtil.success(list, HttpStatus.OK);
    }
}
