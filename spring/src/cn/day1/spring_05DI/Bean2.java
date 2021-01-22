package cn.day1.spring_05DI;

/**
 * 通过Setter设置参数创建实例
 */
public class Bean2 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String print() {
        return "name:"+name + " , age:" + age;
    }
}
