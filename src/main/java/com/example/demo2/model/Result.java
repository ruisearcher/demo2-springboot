package com.example.demo2.model;

import java.util.Map;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/5/26 13:41
 */
public class Result<T> {
    public static final int OK = 0;
    public static final int ERROR = -1;

    /**
     * 返回码
     */
    private Integer flag;
    /**
     * 信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public Result() {
        this.flag = OK;
        this.msg = "操作成功";
        this.data = null;
    }

    private Result(T data) {
        this();
        this.data = data;
    }

    private Result(T data, Integer flag) {
        this();
        this.data = data;
        this.flag = flag;
    }

    private Result(T data, Integer flag, String msg) {
        this();
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.flag.equals(OK);
    }

    private static final String FLAG_KEY = "flag";
    private static final String MSG_KEY = "msg";
    private static final String DATA_KEY = "data";

    @Deprecated
    public static <T>  Result<T> ofMap(Map<String, Object> map, Class<T> clazz) {
        Result<T> result = new Result<>();
        if (map.containsKey(FLAG_KEY)) {
            result.flag = ((Number) map.get(FLAG_KEY)).intValue();
        }
        else {
            throw new RuntimeException("缺少关键字" + FLAG_KEY);
        }
        if (map.containsKey(MSG_KEY)) {
            result.msg = map.get(MSG_KEY).toString();
        }
        else {
            throw new RuntimeException("缺少关键字" + MSG_KEY);
        }
        if (map.containsKey(DATA_KEY)) {
            if (clazz.isInstance(map.get(DATA_KEY))) {
                result.data = clazz.cast(map.get(DATA_KEY));
            }
            else {
                throw new RuntimeException("Map 关键字‘" + DATA_KEY + "’无法转换为当前类型。");
            }
        }
        else {
            throw new RuntimeException("缺少关键字" + DATA_KEY);
        }
        return result;
    }

}
