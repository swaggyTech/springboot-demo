package com.demo.exceptionhandler.exception;

import com.demo.exceptionhandler.constant.Status;
import lombok.Getter;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 11:48
 */
@Getter
public class JsonException extends BaseException {

    public JsonException(Status status){
        super(status);
    }

    public JsonException(Integer code,String message){
        super(code,message);
    }
}
