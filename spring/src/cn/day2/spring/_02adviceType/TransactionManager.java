package cn.day2.spring._02adviceType;

import org.aspectj.lang.ProceedingJoinPoint;

//公用代码
//该类一般叫做通知类
public class TransactionManager {

    public void startTransaction() {
        System.out.println("开启事务....");
    }

    public void startTransaction1() {
        System.out.println("开启事务1....");
    }

    public void commit() {
        System.out.println("提交事务....");
    }

    public void rollback() {
        System.out.println("回滚事务....");
    }

    public void release() {
        System.out.println("释放资源....");
    }

    //环绕通知：提供的一个自由编写的入口
    //Spring框架会把原始的核心业务方法封装到一个对象中ProceedingJoinPoint
    public void around(ProceedingJoinPoint pjp) {
        try {
            startTransaction();
            //核心业务
            Object rtValue = pjp.proceed();//调用当前被调用的切入点
            commit();
        } catch (Throwable e) {
            rollback();
        } finally {
            release();
        }
    }
}
