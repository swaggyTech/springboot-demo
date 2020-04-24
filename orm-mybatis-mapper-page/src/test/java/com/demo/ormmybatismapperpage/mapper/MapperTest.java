package com.demo.ormmybatismapperpage.mapper;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.demo.ormmybatismapperpage.OrmMybatisMapperPageApplicationTests;
import com.demo.ormmybatismapperpage.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/24 14:55
 */
@Slf4j
public class MapperTest extends OrmMybatisMapperPageApplicationTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试通用Mapper - 保存
     */
    @Test
    public void testInsert() {
        String salt = IdUtil.fastSimpleUUID();
        User testsave = User.builder().name("testSave").password(SecureUtil.md5("123456" + salt)).salt(salt).email("test@swaggy.com").phoneNumber("123123").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        userMapper.insertUseGeneratedKeys(testsave);
        Assert.assertNotNull(testsave.getId());
        log.debug("【测试主键回写#testsave.getId()】={}", testsave.getId());
    }

    /**
     * 测试通用Mapper - 批量保存
     */
    @Test
    public void testInsertList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 4; i < 14; i++) {
            String salt = IdUtil.fastSimpleUUID();
            User user = User.builder().name("testSave" + i).password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave" + i + "@swaggy.com").phoneNumber("12341234124" + i).status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
            userList.add(user);
        }
        int i = userMapper.insertList(userList);
        Assert.assertEquals(userList.size(), i);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("【测试主键回写#userList】={}", ids);
    }


    /**
     * 测试通用Mapper - 删除
     */
    @Test
    public void testDelete() {
        Long primaryKey = 1L;
        int i = userMapper.deleteByPrimaryKey(primaryKey);
        Assert.assertEquals(1, i);
        User user = userMapper.selectByPrimaryKey(primaryKey);
        Assert.assertNull(user);
    }

    /**
     * 测试通用Mapper - 更新
     */
    @Test
    public void testUpdate() {
        Long primaryKey = 1L;
        User user = userMapper.selectByPrimaryKey(primaryKey);
        user.setName("通用Mapper名字更新");
        int i = userMapper.updateByPrimaryKeySelective(user);
        Assert.assertEquals(1, i);
        User update = userMapper.selectByPrimaryKey(primaryKey);
        Assert.assertNotNull(update);
        Assert.assertEquals("通用Mapper名字更新", update.getName());
        log.debug("【update】={}", update);
    }

    /**
     * 测试通用Mapper - 查询单个
     */
    @Test
    public void testQueryOne() {
        User user = userMapper.selectByPrimaryKey(1L);
        Assert.assertNotNull(user);
        log.debug("【user】={}", user);
    }

    /**
     * 测试通用Mapper - 查询全部
     */
    @Test
    public void testQueryAll() {
        List<User> userList = userMapper.selectAll();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.debug("【users】+{}", userList);
    }

    /**
     * 测试分页助手 - 分页排序查询
     */
    @Test
    public void testQueryByPageAndSort() {
        initData();
        int currentPage = 1;
        int pageSize = 5;
        String orderBy = "id desc";
        int count = userMapper.selectCount(null);
        PageHelper.startPage(currentPage, pageSize, orderBy);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        Assert.assertEquals(5, userPageInfo.getSize());
        Assert.assertEquals(count, userPageInfo.getTotal());
        log.debug("【userPageInfo】={}", userPageInfo);
    }

    /**
     * 测试通用Mapper - 条件查询
     */
    @Test
    public void testQueryByCondition() {
        initData();
        Example example = new Example(User.class);
        //过滤
        example.createCriteria().andLike("name", "%save1%").orEqualTo("phoneNumber", "17300000001");
        //排序
        example.setOrderByClause("id desc");
        int count = userMapper.selectCountByExample(example);
        //分页
        PageHelper.startPage(1, 3);
        //查询
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        Assert.assertEquals(3, userPageInfo.getSize());
        Assert.assertEquals(count, userPageInfo.getTotal());
        log.debug("【userPageInfo】={}", userPageInfo);
    }


    /**
     * 初始化数据
     */
    public void initData() {
        testInsertList();
    }
}
