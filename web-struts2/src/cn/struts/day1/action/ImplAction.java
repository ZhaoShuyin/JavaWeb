package cn.struts.day1.action;

import com.opensymphony.xwork2.Action;

/**
 * Action 接口
 * String execute() throws Exception;
 * <p>
 * SUCCESS:success  一般正常执行成功时返回
 * NONE:none 一般不需要返回任何结果视图时使用。如同return null;
 * ERROR:error 一般动作方法运行期间出错时返回。
 * INPUT:input 一般错误回显时使用
 * LOGIN:login  一般需要登录时使用
 */
public class ImplAction implements Action {

    //动作方法：动作方法要返回一个字符串
    //Action接口中定义的常量就是给动作方法作为返回值用的
    public String execute() throws Exception {
//		return "success";//容易出错
//		return SUCCESS;//不容易出错；统一开发。常量接口模式
        System.out.println("Action =================== implements().....");
        return NONE;
    }

    public String save() {
        System.out.println("Action =================== implements save().....");
        return SUCCESS;
    }

    public String update() {
        System.out.println("Action =================== implements update().....");
        return null;
    }

}
