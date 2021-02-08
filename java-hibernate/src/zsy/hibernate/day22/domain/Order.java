package zsy.hibernate.day22.domain;

import java.io.Serializable;

public class Order implements Serializable {

    private Integer id;
    private Float money;
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", money=" + money + "]";
    }

}
