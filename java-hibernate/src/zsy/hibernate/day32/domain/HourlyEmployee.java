package zsy.hibernate.day32.domain;

/**
 * 小时工
 */
public class HourlyEmployee extends Employee {
    private Float rate;

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

}
