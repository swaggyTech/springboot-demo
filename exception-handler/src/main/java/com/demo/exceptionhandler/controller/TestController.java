package com.demo.exceptionhandler.controller;

import com.demo.exceptionhandler.constant.Status;
import com.demo.exceptionhandler.exception.JsonException;
import com.demo.exceptionhandler.exception.PageException;
import com.demo.exceptionhandler.model.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 11:26
 */
@Controller
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException(){
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException(){
        throw new PageException(Status.UNKNOWN_ERROR);
    }
}
