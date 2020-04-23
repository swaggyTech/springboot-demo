package com.demo.ormmybatis.mapper;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.demo.ormmybatis.OrmMybatisApplicationTests;
import com.demo.ormmybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/23 14:07
 */
@Slf4j
class MapperTest extends OrmMybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;


    /**
     * 测试查询所有
     */
    @Test
    public void selectAllUser(){
        List<User> userList = userMapper.selectAllUser();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.debug("【userList】={}",userList);
    }


    /**
     * 测试按ID查询
     */
    @Test
    public void selectUserById(){
        User user = userMapper.selectUserById(1L);
        Assert.assertNotNull(user);
        log.debug("【user】={}",user);
    }

    /**
     * 测试保存
     */
    @Test
    public void saveUser(){
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("test3@swaggy.com").phoneNumber("12412344123").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        int i = userMapper.saveUser(user);
        Assert.assertEquals(1, i);
    }

    /**
     * 测试根据主键删除
     */
    @Test
    public void deleteById() {
        int i = userMapper.deleteById(1L);
        Assert.assertEquals(1, i);
    }
}

