package com.myou.jvm.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author myou
 * @Date 2021/1/15  4:26 下午
 */
//@WebListener
public class CustomServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ok");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ok");
    }
}
