package com.demo.ormjpa.repository;

import com.demo.ormjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 16:21
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
}
