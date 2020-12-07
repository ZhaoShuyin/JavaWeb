package spring.day1.spring_07annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Bean2 {
	//初始化方法：执行一次
	@PostConstruct
	public void init(){
		System.out.println("UserDaoImpl....init");
	}
	public void save() {
		System.out.println("UserDaoImpl save....");
	}
	//销毁方法：销毁一次。spring容器关闭时.只有单例模式才有意义
	@PreDestroy
	public void destroy(){
		System.out.println("UserDaoImpl....destroy");
	}
}
