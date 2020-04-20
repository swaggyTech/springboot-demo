package com.demo.jdbctemplate.entity;

import com.demo.jdbctemplate.annotation.Column;
import com.demo.jdbctemplate.annotation.Pk;
import com.demo.jdbctemplate.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/18 11:09
 */
@Data
@Table(name = "orm_user")
public class User implements Serializable {

    @Pk
    private Long id;

    private String name;

    private String password;

    private String salt;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

}
