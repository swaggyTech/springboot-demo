package com.demo.exceptionhandler.handler;

import com.demo.exceptionhandler.exception.JsonException;
import com.demo.exceptionhandler.exception.PageException;
import com.demo.exceptionhandler.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 11:58
 */
@ControllerAdvice
@Slf4j
public class DemoExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(JsonException exception){
        log.error("【JsonException】:{}",exception.getMessage());
        return ApiResponse.ofException(exception);
    }

    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageErrorHandler(PageException exception){
        log.error("【DemoPageException】:{}",exception.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message",exception.getMessage());
        view.setViewName(DEFAULT_ERROR_VIEW);
        return view;
    }
}
