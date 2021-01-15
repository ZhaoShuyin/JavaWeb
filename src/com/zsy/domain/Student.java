package com.zsy.domain;

/**
 * @Title cn.zsy.domain
 */
public class Student {

    private int id;
    private String name;
    private float chinese;
    private float english;
    private float math;


    public Student(){

    }

    public Student(int id, String name, float chinese, float english, float math) {
        this.id = id;
        this.name = name;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getChinese() {
        return chinese;
    }
    public void setChinese(float chinese) {
        this.chinese = chinese;
    }
    public float getEnglish() {
        return english;
    }
    public void setEnglish(float english) {
        this.english = english;
    }
    public float getMath() {
        return math;
    }
    public void setMath(float math) {
        this.math = math;
    }



}

