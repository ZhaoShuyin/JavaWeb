package com.spring.day1.spring_05DI;

/**
 * 使用构造函数和constructor-arg标签给实例赋值
 */
public class Bean1 {
    private String name;
    private int age;

    public Bean1(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String print() {
        return "Bean1 >> { name:" + name + ", age:" + age+" }";
    }
}
