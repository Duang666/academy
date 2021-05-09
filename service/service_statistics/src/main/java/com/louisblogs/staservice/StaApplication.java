package com.louisblogs.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/4 22:54
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.louisblogs"})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.louisblogs.staservice.mapper")
@EnableScheduling
public class StaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaApplication.class,args);
	}

}
