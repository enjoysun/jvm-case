package com.myou.jvm.factory;

import com.myou.jvm.annotatuon.RpcReference;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author myou
 * @Date 2021/1/24  2:01 下午
 */
public class BeanInvohandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            String value = method.getAnnotation(RpcReference.class).value();
            System.out.println(value);
            Object invoke = method.invoke(proxy, args);
            return value;
    }
}
