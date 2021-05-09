package com.louisblogs.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/1 17:52
 */

@ComponentScan(basePackages = {"com.louisblogs"})
@EnableDiscoveryClient     //nacos注册
@SpringBootApplication
@MapperScan("com.louisblogs.educenter.mapper")
public class UcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcenterApplication.class,args);
	}

}
