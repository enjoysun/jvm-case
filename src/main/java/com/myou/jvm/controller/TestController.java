package com.myou.jvm.controller;

import com.myou.jvm.annotatuon.RpcReference;
import com.myou.jvm.config.SendProxy;
import com.myou.jvm.dao.RpcService;
import com.myou.jvm.factory.BeanProxy;
import com.myou.jvm.models.User;
import com.myou.jvm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * @Author myou
 * @Date 2021/1/19  11:12 上午
 */
@RestController
public class TestController {

//    private UserService userService;

//    @Autowired
//    private User user;

//    @Autowired
//    private RpcService service;

    @Autowired
    private RpcService rpcService;

    @GetMapping("/test")
    public void userAdd() {
//        RpcService object = beanProxy.getObject();
        String testProxy = rpcService.testProxy();
//        System.out.println(user.getName());
//        userService.userAdd("123", "12", 12);
        System.out.println("ok");
    }
}
