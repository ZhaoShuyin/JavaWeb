package cn.struts.day4.ognl.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 *
 */
public class Demo1Action extends ActionSupport {

	private String name = "姓名";

	public String execute(){

		ActionContext context = ActionContext.getContext();

		ValueStack vs = context.getValueStack();

		//this.name = 修改后的姓名;
		vs.setValue("name", "修改后的姓名");//特别注意：该方法的第一个参数是ONGL表达式
									            //注意不是set，而是setValue：给root中对象（map）设置属性（value）的值
									            //此处就相当于：对root中第一个有name属性的对象设置值setName("修改后的姓名");

		context.put("key1", "value1");              //向contextmap中放了数据

		vs.setValue("#key1", "value2");         //更改contextMap中的key的值

		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
