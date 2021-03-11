package com.myou.jvm.config;

import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author myou
 * @Date 2021/1/19  10:59 上午
 */
public class SendProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getDeclaringClass().getName());
        System.out.println(Arrays.toString(args));
        System.out.println(method.getName());
        System.out.println(method.getReturnType());
        System.out.println(Arrays.toString(method.getDeclaringClass().getAnnotations()));
        System.out.println(Arrays.toString(method.getParameterTypes()));
        Object res = method.invoke(proxy, args);
        System.out.println("ok");
        return res;
    }
}
