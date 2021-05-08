package cn.day2.spring._03argsRtValue;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//公用代码
//该类一般叫做通知类
public class TransactionManager {

    //此处：获取核心业务代码的参数值。
    public void startTransaction(JoinPoint jp) {//框架会把原始核心业务代码方法用到的参数封装JoinPoint对象中
//        System.out.println("name:>>>>>>>>" + jp.getArgs()[0]);//获取核心业务的参数
        System.out.println("开启事务....");
    }

    public void commit(String rtValue) {
        System.out.println("提交事务....");
        System.out.println("commit return :" + rtValue);
    }

    public void rollback(Throwable e) {
        System.out.println("回滚事务....");
        System.out.println(e.getMessage());
    }

    public void release() {
        System.out.println("释放资源....");
    }

    //环绕通知：提供的一个自由编写的入口
    //Spring框架会把原始的核心业务方法封装到一个对象中ProceedingJoinPoint
	public void around(ProceedingJoinPoint pjp) {
        System.out.println("========= target : "+pjp.getTarget().getClass().getName());
        System.out.println("========= signature : "+pjp.getSignature().getClass().getName());
        System.out.println("========= Kind : "+pjp.getKind());
        try {
			//核心业务
            startTransaction(pjp);
			Object rtValue = pjp.proceed();   //调用当前被调用的切入点
			System.out.println("返回值:"+rtValue);
			commit((String) rtValue);
		} catch (Throwable e) {
			rollback(e);
		}finally{
			release();
		}
	}
}
