package com.wrlhblog.utils;

import lombok.Data;

/**
 * 统一结果封装
 */
@Data
public class RespBean {

    /**
     * 返回状态码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;


    private RespBean(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private RespBean() {
    }

    /**
     * 返回成功(带返回信息与返回数据)
     *
     * @return
     */
    public static RespBean ok(String message, Object data) {
        return new RespBean("200", message, data);
    }

    /**
     * 返回成功(带返回信息无返回数据)
     *
     * @return
     */
    public static RespBean ok(String message) {
        return new RespBean("200", message, null);
    }

    /**
     * 返回失败(带返回信息无返回数据)
     *
     * @return
     */
    public static RespBean error(String message) {
        return new RespBean("500", message, null);
    }

}
