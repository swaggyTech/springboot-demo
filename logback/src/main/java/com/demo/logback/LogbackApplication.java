package com.demo.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class LogbackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LogbackApplication.class, args);
        int length = context.getBeanDefinitionNames().length;
        log.trace("springboot启动初始化了{}个bean",length);
        log.debug("springboot启动初始化了{}个bean",length);
        log.info("springboot启动初始化了{}个bean",length);
        log.warn("springboot启动初始化了{}个bean",length);
        log.error("springboot启动初始化了{}个bean",length);
        try{
            int i = 0;
            int j = 1 / i;
        }catch (Exception e){
            log.error("【springbootDemoLogbackApplication】启动异常：",e);
        }
    }

}
