package com.louisblogs.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description：讲师启动类
 * @author     ：luqi
 * @date       ：2021/3/30 19:04
 */

@SpringBootApplication
@EnableDiscoveryClient     //nacos注册
@EnableFeignClients
@ComponentScan(basePackages = {"com.louisblogs"})
public class EduApplication {

  public static void main(String[] args) {

    SpringApplication.run(EduApplication.class, args);

  }
}
