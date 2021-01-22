package cn.day1.spring_08junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//1、导入jar包：spring-test-3.2.0.RELEASE.jar
@RunWith(SpringJUnit4ClassRunner.class)//更换junit运行器
@ContextConfiguration(locations="classpath:cn/day1/spring_08junit/beans.xml")//指定spring的配置文件
public class MyTest {
	@Autowired//自动注入
	private IService userSerivce;
	@Test
	public void test() {
		userSerivce.regist();
	}

}
