package com.myou.jvm;

import com.myou.jvm.annotatuon.EnableProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.lang.reflect.Proxy;

@SpringBootApplication
//@ServletComponentScan
//@EnableProxy
public class JvmTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvmTestApplication.class, args);
    }

}
