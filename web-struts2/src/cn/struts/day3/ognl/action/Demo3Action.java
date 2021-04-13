package cn.struts.day3.ognl.action;

import java.util.Calendar;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 熟悉ValueStack中的API
 */
public class Demo3Action extends ActionSupport {

	public String execute(){
		//如何获取ValueStack的实例
		ActionContext ac = ActionContext.getContext();//从当前线程上获取的
		//考试：
//		ValueStack vs1 = (ValueStack) ((Map<String,Object>)ac.getContextMap().get("request")).get("struts.valueStack");
		ValueStack vs = ac.getValueStack();
		
		vs.set("key1", "value1");  //判断栈顶对象是不是一个Map类型对象
							//不是：创建一个新的map，把p=p1放到map中，再把map压入栈顶
							//是：直接把p=p1放到栈顶的map中
		vs.set("key2", "value2");
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2015, 10, 1);
		vs.push(c1.getTime());//把一个日期对象压入栈顶

//        Object pop = vs.pop();  //弹栈

//        Object peek = vs.peek();//不会弹栈，获取栈顶对象

        return SUCCESS;
	}
}
