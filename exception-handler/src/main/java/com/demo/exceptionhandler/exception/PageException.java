package com.demo.exceptionhandler.exception;

import com.demo.exceptionhandler.constant.Status;
import lombok.Getter;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 11:49
 */
@Getter
public class PageException extends BaseException{

    public PageException(Status status){
        super(status);
    }

    public PageException(Integer code,String message){
        super(code, message);
    }
}
