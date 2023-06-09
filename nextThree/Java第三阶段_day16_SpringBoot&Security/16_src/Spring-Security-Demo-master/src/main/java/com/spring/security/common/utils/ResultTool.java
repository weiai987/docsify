package com.spring.security.common.utils;


import com.spring.security.common.entity.JsonResult;
import com.spring.security.common.enums.ResultCode;

/**
 * @Author:
 * @Description:
 * @Date Create in
 */
public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}
