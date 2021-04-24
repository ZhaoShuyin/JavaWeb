package cn.day1.spring_07annotation;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext(
                        "cn/day1/spring_07annotation/beans.xml"
                );

        System.out.println("初始化完毕==============================");

        //@Component("bb1")使用注解标记Bean
		/*Bean1 bean1 = (Bean1)ac.getBean("bb1");
		System.out.println("bean1 : "+bean1);*/

        //@Component使用类名
        //@PostConstruct @PreDestroy设置周期方法
		/*Bean2 bean2 = (Bean2) ac.getBean("bean2");
		System.out.println("bean2 : "+bean2);*/

        //@Bean(name="b3")工厂类使用注解
		/*Bean3 bean3 = (Bean3) ac.getBean("b3");
		System.out.println("bean3 : "+bean3);*/


        //@Repository("user")注解
		/*UserImpl userimpl = (UserImpl)ac.getBean("user");
		System.out.println("userimpl : "+userimpl);
		userimpl.save();*/


        //@Service("ServiceA")
        //成员变量使用@Autowired  @Qualifier("user")
		/*ServiceA userService = (ServiceA)ac.getBean("ServiceA");
		userService.regist();*/

        //@Resource(name="ServiceB") 成员变量
        UserAction userAction = (UserAction) ac.getBean("userAction");
        userAction.execute();
    }
}
