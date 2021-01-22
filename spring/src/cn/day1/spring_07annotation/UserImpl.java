package cn.day1.spring_07annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
//持久层

/**
 * @Component：让spring管理的资源，实例化bean
 * @Repository：用在持久层组件
 * @Service：用在业务层组件
 * @Controller：用在表现层组件
 */
@Repository("user")
public class UserImpl {

    public UserImpl() {
        System.out.println("UserImpl 的构造方法");
    }

    public void save() {
        System.out.println("UserImpl save 方法");
    }
}
