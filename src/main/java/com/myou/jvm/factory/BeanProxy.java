package com.myou.jvm.factory;

import com.myou.jvm.annotatuon.RpcReference;
import lombok.SneakyThrows;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author myou
 * @Date 2021/1/24  12:36 下午
 */
public class BeanProxy<T> implements FactoryBean<T> {
    private Class<T> aClass;


    public BeanProxy(Class<T> aClass) {
        this.aClass = aClass;
    }

    @Override
    public T getObject() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{this.aClass}, new BeanInvohandler());
    }

    @Override
    public Class<?> getObjectType() {
        return this.aClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
