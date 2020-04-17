package com.demo.adminclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/17 18:31
 */
@RestController
public class IndexController {

    /**
     *  value默认是一个数组
     */
    @GetMapping(value = {"","/"})
    public String index(){
        return "This is a springboot Admin Client";
    }
}
