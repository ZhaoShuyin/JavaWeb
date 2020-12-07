package spring.day1.spring_05DI;

public class Bean2 {
	private String name;
	private int age;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String print(){
		return name+":"+age;
	}
}
