package com.louisblogs.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description：OSS模块启动类
 * @author     ：luqi
 * @date       ：2021/3/30 19:04
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.louisblogs"})
public class OssApplication {

  public static void main(String[] args) {
    SpringApplication.run(OssApplication.class, args);
  }
}
