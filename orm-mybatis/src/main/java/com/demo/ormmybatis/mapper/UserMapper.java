package com.demo.ormmybatis.mapper;

import com.demo.ormmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/23 13:45
 */
@Mapper
@Component
public interface UserMapper {


    /**
     * 查询所有用户
     * @return 用户列表
     */
    @Select("SELECT * FROM orm_user")
    List<User> selectAllUser();


    /**
     * @param id {主键id}
     * @return 当前id用户，不存在则返回{@code null}
     */
    @Select("SELECT * FROM orm_user WHERE id = #{id}")
    User selectUserById(@Param("id") Long id);


    /**
     * @param user 用户
     * @return 成功 {@code 1} 失败 {@code 0}
     */
    int saveUser(@Param("user") User user);


    /**
     * @param id 主键id
     * @return 成功 {@code 1} 失败 {@code 0}
     */
    int deleteById(@Param("id") Long id);
}
