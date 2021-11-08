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
        System.out.println("A中单独变量");
        System.out.println(compare(ItemBean.class, RemoteItemBean.class));
        System.out.println("============================================");
        System.out.println("B中单独变量");
        System.out.println(compare(RemoteItemBean.class, ItemBean.class));
        System.out.println("============================================");
        System.out.println("AB中相同变量");
        System.out.println(compareSame(RemoteItemBean.class, ItemBean.class));
    }


    public static String compare(Class clazzA, Class clazzB) {
        StringBuilder builder = new StringBuilder();
        Field[] fieldsA = clazzA.getFields();
        for (int i = 0; i < fieldsA.length; i++) {
            Field field = fieldsA[i];
            String name = field.getName();
            String type = field.getType().getName();
            String prefix = null;
            switch (type) {
                case "java.lang.String":
                    prefix = "public String ";
                    break;
                case "java.lang.Double":
                    prefix = "public Double ";
                    break;
                case "int":
                    prefix = "public int ";
                    break;
                case "boolean":
                    prefix = "public boolean ";
                    break;
            }
            boolean b = false;
            try {
                Field clazzBField = clazzB.getField(name);
                if (clazzBField != null && clazzBField.getType() == field.getType()) {
                    b = true;
                }
            } catch (Exception e) {

            }
            if (!b) {
                builder.append(prefix  + name + ";\n");
            }
        }

        return builder.toString();
    }


    public static String compareSame(Class clazzA, Class clazzB) {
        StringBuilder builder = new StringBuilder();
        Field[] fieldsA = clazzA.getFields();
        for (int i = 0; i < fieldsA.length; i++) {
            Field field = fieldsA[i];
            String name = field.getName();
            String type = field.getType().getName();
            String prefix = null;
            switch (type) {
                case "java.lang.String":
                    prefix = "public String ";
                    break;
                case "java.lang.Double":
                    prefix = "public Double ";
                    break;
                case "int":
                    prefix = "public int ";
                    break;
                case "boolean":
                    prefix = "public boolean ";
                    break;
            }
            boolean b = false;
            try {
                Field clazzBField = clazzB.getField(name);
                if (clazzBField != null && clazzBField.getType() == field.getType()) {
                    b = true;
                }
            } catch (Exception e) {

            }
            if (b) {
                builder.append(prefix  + name + ";\n");
            }
        }
        return builder.toString();
    }

}
