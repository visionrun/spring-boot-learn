package com.noobrun.exception;

import com.noobrun.enums.ResultEnum;

/**
 * Created by lenovo on 2017/3/15.
 */
public class MyException extends RuntimeException{
    private Integer code;
    private String msg;

    public MyException(ResultEnum userAgeError) {
        super(userAgeError.getMsg());
        this.code = userAgeError.getCode();
    }

    public MyException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
