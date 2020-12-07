package spring.day1.spring_07annotation;

import org.springframework.stereotype.Component;

//<bean id="bean1" class="spring.day1.spring_07annotation.Bean1"/>
//使用注解
@Component("bb1") //bean的名称是:简单类名,首字母小写
public class Bean1 {
	private String name = "陈涔";
	private int age = 20;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Bean1 [name=" + name + ", age=" + age + "]";
	}
	
}
