package com.young.exception;

import com.young.enums.ResultEnum;

/**
 * @author: young
 * @create: 2019/1/26 17:12
 * @desc: 业务异常
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public BusinessException setCode(Integer code) {
        this.code = code;
        return this;
    }
}
