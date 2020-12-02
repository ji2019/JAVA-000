package com.iw2f.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.iw2f.bean.DBContextHolder;

@Aspect
@Component
public class DataSourceAop {
    /**
     * 只读：
     * 不是Master注解的对象或方法  && select开头的方法  ||  get开头的方法
     */
    @Pointcut("!@annotation(com.iw2f.annotation.Master) " +
            "&& (execution(* com.iw2f.service..*.select*(..)) " +
            "|| execution(* com.iw2f.service..*.get*(..)))")
    public void readPointcut() {

    }

    /**
     * 写：
     * Master注解的对象或方法 || insert开头的方法  ||  add开头的方法 || update开头的方法
     * || edlt开头的方法 || delete开头的方法 || remove开头的方法
     */
    @Pointcut("@annotation(com.iw2f.annotation.Master) " +
            "|| execution(* com.iw2f.service..*.insert*(..)) " +
            "|| execution(* com.iw2f.service..*.add*(..)) " +
            "|| execution(* com.iw2f.service..*.update*(..)) " +
            "|| execution(* com.iw2f.service..*.edit*(..)) " +
            "|| execution(* com.iw2f.service..*.delete*(..)) " +
            "|| execution(* com.iw2f..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
