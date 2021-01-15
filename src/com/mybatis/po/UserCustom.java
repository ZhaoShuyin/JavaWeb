package com.mybatis.po;

/**
 * 使用拓展类装调查询返回结果
 * 包含User的基本信息和自定义添加的信息
 */
public class UserCustom extends User{
    public String tag = "tag";

    @Override
    public String toString() {
        return "{ tag: tag"+", user:"+super.toString()+" }";
    }
}
