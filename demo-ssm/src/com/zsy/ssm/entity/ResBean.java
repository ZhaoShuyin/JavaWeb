package com.zsy.ssm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Title 响应统一格式Bean
 * @date 2020/1/10
 * @autor Zsy
 */
public class ResBean implements Serializable {

    public int code = 0;
    public String msg;
    public Object data;

    public ResBean() {
    }

    public ResBean(String msg, Object o) {
        if (o == null) {
            code = 0;
            msg += "为空";
        } else {
            if (o instanceof List){
                if (((List) o).size()==0){
                    code = 0;
                    msg += "为空";
                }else{
                    code = 1;
                    msg += "成功";
                }
            }else{
                code = 1;
                msg += "成功";
            }
        }
        this.msg = msg;
        data = o;
    }

    public ResBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
