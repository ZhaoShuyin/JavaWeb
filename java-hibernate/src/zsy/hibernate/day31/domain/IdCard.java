package zsy.hibernate.day31.domain;

import java.io.Serializable;

public class IdCard implements Serializable {

    private Integer id;
    private String num;
    private IPerson person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public IPerson getPerson() {
        return person;
    }

    public void setPerson(IPerson person) {
        this.person = person;
    }

}
