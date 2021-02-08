package zsy.hibernate.day32.domain;

public class SalaryEmployee extends Employee {
    private Float salary;

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

}
