package zsy.hibernate.day30.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {

    private Integer id;
    private String name;
    private String grade;
    private Set<Teacher> teachers = new HashSet<Teacher>(0);

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade
                + "]";
    }

}
