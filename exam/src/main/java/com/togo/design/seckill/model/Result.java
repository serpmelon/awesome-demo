package com.togo.design.seckill.model;

/**
 * @Author taiyn
 * @Description
 * @Date 下午6:10 2022/3/6
 **/
public class Result<T> {

    /**
     * 0 成功; -1 失败
     */
    private int code;
    /**
     * 成功或失败信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    private static final int SUCCESS = 0;
    private static final int FAIL = -1;

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, "", data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(FAIL, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
