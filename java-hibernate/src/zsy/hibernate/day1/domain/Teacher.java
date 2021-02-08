package zsy.hibernate.day1.domain;

import java.io.Serializable;

public class Teacher implements Serializable {

    private Integer id;
    private String name;
    private Float salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", salary=" + salary
                + "]";
    }

}
