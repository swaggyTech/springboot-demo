package com.demo.ormmybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/24 16:18
 */
@Configuration
@MapperScan(basePackages = {"com.demo.ormmybatisplus.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 性能分析拦截器，不建议生产使用
     * @return
     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor(){
//        return new PerformanceInterceptor();
//    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
