package com.louisblogs.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/23 10:14
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.louisblogs"})
public class VodApplication {

	public static void main(String[] args) {
		SpringApplication.run(VodApplication.class, args);
	}

}
