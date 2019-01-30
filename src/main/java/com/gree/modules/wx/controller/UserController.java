package com.gree.modules.wx.controller;


import com.gree.common.utils.ResultUtil;
import com.gree.modules.wx.service.UserService;
import com.gree.modules.wx.entity.User;
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
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/wx/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "添加用户")
	@PostMapping("/save")
	public ResponseEntity save(@RequestBody User user){
		userService.save(user);
		return ResultUtil.success(HttpStatus.OK);
	}
}
