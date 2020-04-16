package com.demo.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/16 14:39
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
