package com.myou.jvm.annotatuon;

import com.myou.jvm.register.ProxyRegister;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ProxyRegister.class)
public @interface EnableProxy {
    String scanBasePackage() default "classpath*:";
}
