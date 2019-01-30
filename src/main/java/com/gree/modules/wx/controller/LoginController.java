package com.gree.modules.wx.controller;

import com.gree.common.utils.MD5Utils;
import com.gree.common.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity login(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return ResultUtil.success(HttpStatus.OK);
		} catch (UnknownAccountException e) {
			return ResultUtil.error(e.getMessage(),HttpStatus.UNAUTHORIZED);
		} catch (IncorrectCredentialsException e) {
			return ResultUtil.error(e.getMessage(),HttpStatus.UNAUTHORIZED);
		} catch (LockedAccountException e) {
			return ResultUtil.error(e.getMessage(),HttpStatus.UNAUTHORIZED);
		} catch (AuthenticationException e) {
			return ResultUtil.error("认证失败！",HttpStatus.UNAUTHORIZED);
		}
	}
}
