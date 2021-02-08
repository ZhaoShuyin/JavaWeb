package zsy.hibernate.day1.domain;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //在属性中加入程序逻辑
    public String getName() {
        return firstName + "." + lastName;//阿诺.斯瓦辛格
    }

    public void setName(String name) {//阿诺.斯瓦辛格
        if (name != null) {
            firstName = name.split("\\.")[0];
            lastName = name.split("\\.")[1];
        }
    }


}
