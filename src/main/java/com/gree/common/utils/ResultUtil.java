package com.gree.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil{
	public static ResponseEntity success(Object object, HttpStatus status){
		Map<String,Object> map = new HashMap<>();
		map.put("msg", "success");
		map.put("data", object);
	return new ResponseEntity(map,status);
	}

	public static ResponseEntity success(HttpStatus status) {
		return success(null,status);
	}

	public static ResponseEntity error(String msg, HttpStatus status){
		Map<String,Object> map = new HashMap<>();
		map.put("msg", msg);
		return new ResponseEntity(map,status);
	}
}