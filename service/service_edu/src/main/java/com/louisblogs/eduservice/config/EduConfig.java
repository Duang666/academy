package com.louisblogs.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description：EDU工具类
 * @author     ：luqi
 * @date       ：2021/3/30 19:07
 */

@Configuration
@MapperScan("com.louisblogs.eduservice.mapper")
public class EduConfig {

  /** 逻辑删除插件 */
  @Bean
  public ISqlInjector sqlInjector() {
    return new LogicSqlInjector();
  }

  /** 分页插件 */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }
}
