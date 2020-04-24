package com.demo.ormmybatismapperpage.mapper;

import com.demo.ormmybatismapperpage.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/24 14:48
 */
@Component
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
