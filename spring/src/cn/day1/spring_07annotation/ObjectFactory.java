package cn.day1.spring_07annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 @Configuration 配置工程类
 * 生产bean的工厂
 * 使用 @Bean(name = "b3") 获取对象
 */
@Configuration
public class ObjectFactory {
    @Bean(name = "b3")
    public Bean3 genBean3() {
        return new Bean3();
    }
}
