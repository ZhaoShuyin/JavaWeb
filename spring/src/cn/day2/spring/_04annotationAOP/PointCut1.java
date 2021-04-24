package cn.day2.spring._04annotationAOP;

import org.aspectj.lang.annotation.Pointcut;

public class PointCut1 {

    //相当于:
    @Pointcut("execution(* cn.day2.spring._04annotationAOP.*.*(..))")
    public void pt1() {
        System.out.println("================== @Pointcut ================");
    }

}
