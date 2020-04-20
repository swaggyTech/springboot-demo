package com.demo.jdbctemplate.service;

import com.demo.jdbctemplate.entity.User;

import java.util.List;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/18 11:04
 */
public interface IUserService {

    Boolean save(User user);

    Boolean delete(Long id);

    Boolean update(User user,Long id);

    User getUser(Long id);

    List<User> getUser(User user);
}
