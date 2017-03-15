package com.noobrun.enums;

/**
 * Created by lenovo on 2017/3/15.
 */
public enum ResultEnum {
    SUCCESS(200,"操作成功"),
    PARAM_ERROR(201,"参数有误，请重试"),
    USER_AGE_ERROR(202,"未满18岁静止入内"),
    DATA_NOT_FOUND(203,"当前数据不存在")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
