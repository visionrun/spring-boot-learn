package com.noobrun.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by lenovo on 2017/3/15.
 */
@Aspect
@Component
public class LogAspect {
    private final static Logger log= LoggerFactory.getLogger(LogAspect.class);
    @Pointcut(value = "execution(public * com.noobrun.controller.UserController.*(..))")
    public void pointcut(){
    }

    @Before(value = "pointcut()")
    public void before(){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        log.info("请求地址为：{}",request.getRequestURL());
        log.info("请求方法为：{}",request.getMethod());
        log.info("请求参数为：{}",request.getParameterMap());
    }
}
