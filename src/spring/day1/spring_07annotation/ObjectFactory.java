package spring.day1.spring_07annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//生产bean的工厂
@Configuration
public class ObjectFactory {
	@Bean(name="b3")
	public Bean3 genBean3(){
		return new Bean3();
	}
}
