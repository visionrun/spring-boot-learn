package com.noobrun.utils;

import com.noobrun.domain.Result;
import com.noobrun.enums.ResultEnum;

/**
 * Created by lenovo on 2017/3/15.
 */
public class ResultUtil {
    /**
     * 操作成功
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**
     * 操作成功
     * @return
     */
    public static Result success(){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 操作失败
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
