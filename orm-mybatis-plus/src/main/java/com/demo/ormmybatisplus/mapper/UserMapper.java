package com.demo.ormmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.ormmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/24 16:16
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
