package com.example.demo2.exception;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/6/7 9:33
 */
@Data
@Accessors(chain = true)
public class JsonResult<T> implements Serializable {

    /**
     * 异常码
     */
    protected int code;
    /**
     * 时间
     */
    protected String time;
    /**
     * 数据
     */
    protected T data;
    /**
     * 异常信息
     */
    protected String msg;

    public JsonResult() {
        this.code = 200;
        this.time = DateUtil.now();
        this.msg = "操作成功";
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.time = DateUtil.now();
        this.msg = msg;
    }

    public static <T> JsonResult<T> ofData(T data) {
        return new JsonResult<T>().setData(data);
    }

    public static <T> JsonResult<T> of(String msg, T data) {
        return new JsonResult<T>().setMsg(msg).setData(data);
    }

    public static <T> JsonResult<T> of(String msg) {
        return new JsonResult<T>().setMsg(msg);
    }

    public static <T> JsonResult<T> err() {
        return new JsonResult<T>(400, "错误");
    }

    public static  JsonResult err(String msg) {
        return new JsonResult(400, msg);
    }

    public static <T> JsonResult<T> err(int code, String msg) {
        return new JsonResult<T>(code, msg);
    }

    public String toJson() {
        return JSONUtil.toJsonStr(this);
    }
}