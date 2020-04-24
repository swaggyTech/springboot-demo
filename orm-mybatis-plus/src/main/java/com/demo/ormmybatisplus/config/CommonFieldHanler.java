package com.demo.ormmybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/24 16:18
 */
@Slf4j
@Component
public class CommonFieldHanler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ......");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("lastUpdateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ......");
        this.setFieldValByName("lastUpdateTime",new Date(),metaObject);
    }
}
