package com.demo.logaop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/21 17:05
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Dict test(String who){
        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
    }
}
