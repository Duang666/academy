package com.louisblogs.eduorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/3 20:09
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("com.louisblogs")
@MapperScan("com.louisblogs.eduorder.mapper")
public class OrdersApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class,args);
	}

}
