package com.young.utils;

import com.young.data.Result;

/**
 * @author:       young
 * @create:       2019/1/26 16:46
 * @desc:         返回结果封装类
 */
public class ResultUtil {
    
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    
    public static Result success(){
        return success(null);
    }
    
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
