package cn.day1.spring_05DI;

/**
 * 通过配置构造参数创建实例
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
        return "name:"+name + " , age:" + age;
    }
}
