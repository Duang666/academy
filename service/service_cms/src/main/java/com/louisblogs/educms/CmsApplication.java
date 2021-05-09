package com.louisblogs.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/30 9:53
 */

@SpringBootApplication
@ComponentScan({"com.louisblogs"})    //指定扫描位置
@EnableDiscoveryClient
@MapperScan("com.louisblogs.educms.mapper")
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

}
