package com.myou.jvm.config;

import com.myou.jvm.models.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author myou
 * @Date 2021/1/23  5:43 下午
 */
//@Component
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.isSingleton();
        genericBeanDefinition.setBeanClass(User.class);
        genericBeanDefinition.getPropertyValues().add("name", "张三");
        beanDefinitionRegistry.registerBeanDefinition("user", genericBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
