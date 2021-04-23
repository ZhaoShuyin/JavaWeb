package cn.day3.springjdbc._02daoSupport;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float amount;

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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", amount=" + amount
                + "]";
    }

}
