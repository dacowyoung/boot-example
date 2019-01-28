package com.young.enums;

/**
 * @author: young
 * @create: 2019/1/26 17:38
 * @desc: 返回结果枚举
 */
public enum ResultEnum {

    SERVER_ERROR(500, "服务器错误"),
    SUCCESS(0, "成功"),
    LITTLE_BOY(100, "小屁孩"),
    YOUNG_MAN(101, "小伙子"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
