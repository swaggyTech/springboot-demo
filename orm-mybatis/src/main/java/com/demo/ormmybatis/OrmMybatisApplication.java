package com.demo.ormmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.demo.ormmybatis.mapper"})
@SpringBootApplication
public class OrmMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmMybatisApplication.class, args);
    }

}
