package com.gree.common.exception;

import com.gree.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger  = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RRException.class)
	public ResponseEntity handleRRException(RRException e){
		logger.error(e.getMessage(), e);
		return ResultUtil.error(e.getMessage(), e.getCode());
	}


	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity handleNumberFormatException(NumberFormatException e){
		logger.error(e.getMessage(), e);
		return ResultUtil.error("参数类型有误", HttpStatus.BAD_REQUEST);
	}
}
