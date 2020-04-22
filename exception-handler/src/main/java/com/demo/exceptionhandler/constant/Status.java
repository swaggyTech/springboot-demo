package com.demo.exceptionhandler.constant;

import lombok.Getter;

/**
 *
 * <p>
 *     状态码封装
 *     </>
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 11:31
 */
@Getter
public enum Status {
    /**
     * 操作成功
     */
    OK(200,"操作成功"),
    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500,"服务器出错");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;
    Status(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}