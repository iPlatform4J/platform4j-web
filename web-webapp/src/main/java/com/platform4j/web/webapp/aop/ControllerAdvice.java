package com.platform4j.web.webapp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerAdvice implements MethodInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(ControllerAdvice.class.getName());

    public Object invoke(MethodInvocation invocation) throws Throwable{
        doBeforeMethod(invocation);
        Object result = invocation.proceed();
        doAfterMethod(invocation);
        return result;
    }

    private void doBeforeMethod(MethodInvocation invocation){
        logger.info(" ControllerAdvice doBeforeMethod");
    }

    private void doAfterMethod(MethodInvocation invocation){
        logger.info(" ControllerAdvice doAfterMethod");
    }

}
