package com.zsy.ssm.controller;

import com.zsy.ssm.entity.ResBean;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title com.zsy.ssm.controller
 * @date 2021/5/16
 * @autor Zsy
 */

public class BaseController {

    protected String getErrors(BindingResult result) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            builder.append(error.getDefaultMessage()+",");
//            builder.append(error.getField() + ":" + error.getDefaultMessage() + ", ");
        }
        builder.append("]");
        return builder.toString();
    }

    protected ResBean response(BindingResult result) {
        return new ResBean(-1, getErrors(result));
    }

    protected ResBean response(String message, Object data) {
        return new ResBean(1, message, data);
    }

}
