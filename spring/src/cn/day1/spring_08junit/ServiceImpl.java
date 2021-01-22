package cn.day1.spring_08junit;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements IService {
	public void regist() {
		System.out.println("regist...........");
	}

}
