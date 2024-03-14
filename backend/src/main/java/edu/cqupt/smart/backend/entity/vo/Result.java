package edu.cqupt.smart.backend.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package_Name: edu.cqupt.smart.backend.entity
 * @Description: message在controller层封装，其余均在service层封装
 * @Date: 2024/3/1 18:28
 * @Created: SiriAo
 */
@Getter
@Setter
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap();

    //成功静态方法
    public static Result ok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("请求成功");
        return r;
    }

    //失败静态方法
    public static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("请求失败");
        return r;
    }

    public static Result empty() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.EMPTY);
        r.setMessage("暂无数据");
        return r;
    }

    public Result addData(String s, Object o) {
        data.put(s, o);
        return this;
    }

}
