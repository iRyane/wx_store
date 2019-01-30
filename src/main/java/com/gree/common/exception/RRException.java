package com.gree.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @Author :yan
 * @Date :Create in 12/18/18
 * @Description :自定义异常
 */

public class RRException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private HttpStatus code = HttpStatus.INTERNAL_SERVER_ERROR;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, HttpStatus code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, HttpStatus code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }


}
