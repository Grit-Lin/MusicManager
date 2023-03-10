package com.starnet.musicmanager.common;

import com.starnet.musicmanager.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author:
 * @date:
 * @description 全局异常处理
 */

//表示代理所有有这两个注解的类
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)//表示一旦抛出这种异常，就会被这个类处理
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException exception) {
        log.error(exception.getMessage());
        return R.error("数据库操作失败！");
    }

    @ExceptionHandler(MyException.class)
    public R<String> exceptionHandler(MyException exception) {
        log.error(exception.getMessage());
        return R.error(exception.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public R<String> exceptionHandler(NullPointerException exception) {
        log.error(exception.getMessage());
        return R.error("查询失败，数据不存在！");
    }

    @ExceptionHandler(RuntimeException.class)
    public R<String> exceptionHandler(RuntimeException exception) {
        log.error(exception.getMessage());
        return R.error(exception.getMessage());
    }
}
