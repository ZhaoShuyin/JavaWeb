package com.date;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Title PACKAGE_NAME
 * @date 2021/5/13
 * @autor Zsy
 */

public class Test {

    public static void main(String[] args) {
        System.out.println(compare(ItemBean.class,RemoteItemBean.class));
        System.out.println(compare(RemoteItemBean.class,ItemBean.class));
    }


    public static String compare(Class clazzA, Class clazzB) {
        StringBuilder builder = new StringBuilder();
        Field[] fieldsA = clazzA.getFields();
        builder.append("A中单独变量:\n");
        for (int i = 0; i < fieldsA.length; i++) {
            Field field = fieldsA[i];
                String name = field.getName();
                String type = field.getClass().getName();
                boolean b = false;
                try{
                    b = (clazzB.getField(name) != null);
                }catch (Exception e){

                }
                if (!b) {
                    builder.append(type+" "+name+"\n");
                }
        }
        builder.append("=============================");
        return builder.toString();
    }

}
