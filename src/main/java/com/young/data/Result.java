package com.young.data;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author: young
 * @create: 2019/1/26 16:36
 * @desc: 统一返回结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private Integer code;

    private String msg;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
