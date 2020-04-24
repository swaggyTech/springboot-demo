package com.demo.ormmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.ormmybatisplus.entity.User;
import com.demo.ormmybatisplus.mapper.UserMapper;
import com.demo.ormmybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/24 16:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
