package com.noobrun.handle;

import com.noobrun.domain.Result;
import com.noobrun.exception.MyException;
import com.noobrun.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/3/15.
 */
@ControllerAdvice
public class ExceptionHandle {
    /**
     * 定义异常处理器
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandle(Exception e){
        e.printStackTrace();
        if(e instanceof MyException){
            MyException myException= (com.noobrun.exception.MyException) e;
            return ResultUtil.error(myException.getCode(),e.getMessage());
        }else{
            return ResultUtil.error(-1,e.getMessage());
        }
    }
}
