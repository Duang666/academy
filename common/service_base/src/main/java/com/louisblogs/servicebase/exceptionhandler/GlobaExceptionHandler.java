package com.louisblogs.servicebase.exceptionhandler;

import com.louisblogs.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description：统一处理异常处理类
 * @author     ：luqi
 * @date       ：2021/4/1 17:04
 */

@ControllerAdvice  //统一处理异常处理
@Slf4j
public class GlobaExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理");
    }

    //自定义异常
    @ExceptionHandler(LouisblogsException.class)
    @ResponseBody //为了返回数据
    public R error(LouisblogsException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
















