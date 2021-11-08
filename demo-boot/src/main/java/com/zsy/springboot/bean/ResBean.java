package com.zsy.springboot.bean;

/**
 * @Title com.zsy.springboot.bean
 * @date 2021/8/3
 * @autor Zsy
 */

public class ResBean {

    public int code;
    public String msg;
    public Object data;

    public ResBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
