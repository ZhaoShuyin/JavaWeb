package cn.day2.tx.view;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.day2.tx.service.IService;
import cn.day2.tx.util.TransactionManager;

/**
 * @Title cn.day2.tx3.view
 */
public class MyInvocationHandler implements InvocationHandler {
    private IService s;//被代理对象。没有事务的

    public MyInvocationHandler(IService s) {
        this.s = s;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        System.out.println("代理 方法");
        try {
            TransactionManager.startTransaction();
            Object rtValue = method.invoke(s, args);//原始对象的核心业务代码
            TransactionManager.commit();
            return rtValue;
        } catch (Exception e) {
            TransactionManager.rollback();
        } finally {
            TransactionManager.release();
        }
        return null;
    }

}
