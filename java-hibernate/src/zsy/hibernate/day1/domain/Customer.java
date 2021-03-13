package zsy.hibernate.day1.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Customer implements Serializable {

    private Integer id;
    private String name;
    private Date birthday;
    private Double totalMoney;//当前客户购买的商品的总价

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", birthday="
                + birthday + ", totalMoney=" + totalMoney + "]";
    }


}
