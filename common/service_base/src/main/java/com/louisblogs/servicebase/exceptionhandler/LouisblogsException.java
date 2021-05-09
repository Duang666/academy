package com.louisblogs.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description：
 * @author     ：luqi
 * @date       ：2021/4/1 17:04
 */

@Data                   //生成get和set方法
@AllArgsConstructor   //生成有参数构造方法
@NoArgsConstructor       //生成无参数构造
public class LouisblogsException extends RuntimeException {

    private Integer code;   //状态码

    private String msg;     //异常处理

}
