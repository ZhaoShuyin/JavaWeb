package cn.day2.spring._04annotationAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect   //@Aspect把类声明为切面(通知类)
public class TransactionManager {

    //
    @Before(value = "PointCut1.pt1()")
    public void startTransaction() {
        System.out.println("开启事务....");
    }

    @AfterReturning(value = "PointCut1.pt1()", returning = "rtValue")
    public void commit(String rtValue) {
        System.out.println("返回值:" + rtValue);
        System.out.println("提交事务....");
    }

    @Around(value = "PointCut1.pt1()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("doAround :" + pjp.toString());
        Object obj = pjp.proceed();
        return obj;
    }

}
