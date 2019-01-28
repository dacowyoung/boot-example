package com.young.handler;

import com.young.data.Result;
import com.young.exception.BusinessException;
import com.young.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: young
 * @create: 2019/1/26 17:07
 * @desc: ctrl异常捕获
 */
@ControllerAdvice
public class ExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return ResultUtil.error(businessException.getCode(), businessException.getMessage());
        }
        log.error("[系统异常]{}",e);
        return ResultUtil.error(500, "服务器错误,请联系管理员");
    }
}
