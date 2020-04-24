package com.demo.ormmybatismapperpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"com.demo.ormmybatismapperpage.mapper"})
@SpringBootApplication
public class OrmMybatisMapperPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmMybatisMapperPageApplication.class, args);
    }

}
