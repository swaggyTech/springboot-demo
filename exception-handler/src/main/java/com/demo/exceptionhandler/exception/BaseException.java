package com.demo.exceptionhandler.exception;

import com.demo.exceptionhandler.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 11:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{
    private Integer code;
    private String message;

    public BaseException(Status status){
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
