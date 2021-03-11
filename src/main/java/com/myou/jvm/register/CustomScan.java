package com.myou.jvm.register;

import com.myou.jvm.factory.BeanProxy;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Arrays;
import java.util.Set;

/**
 * @Author myou
 * @Date 2021/1/24  2:10 下午
 */
public class CustomScan extends ClassPathBeanDefinitionScanner {
    public CustomScan(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    /**
     * 注册过滤器
     */
    public void registerFilters() {
        boolean flag = true;

        //to do

        if (flag) this.addIncludeFilter((reader, readerFactory) -> true);

    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {

        //这一步调用父类的doScan() 会给注册进BeanDefinitionMap里边去
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);

        if (beanDefinitions.isEmpty()) {
            this.logger.warn("No mapper was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
        } else {
            this.processBeanDefinitions(beanDefinitions);
        }

        return beanDefinitions;
    }

    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }


    /**
     * 专门用来处理 BeanDefinition
     *
     * @param beanDefinitions
     */
    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {

        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitions) {

            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();

            //设置构造参数
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());

            //设置为我自定义的FactoryBean
            beanDefinition.setBeanClass(BeanProxy.class);
        }


    }
}
