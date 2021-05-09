package com.louisblogs.msmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/30 21:34
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan("com.louisblogs")
public class MsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsmApplication.class,args);
	}

}
