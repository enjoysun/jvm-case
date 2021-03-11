package com.myou.jvm.register;

import com.myou.jvm.annotatuon.EnableProxy;
import com.myou.jvm.factory.BeanProxy;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author myou
 * @Date 2021/1/24  12:14 下午
 */
public class ProxyRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableProxy.class.getName()));
//        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        if (null != annotationAttributes) {
            String[] scanPaths = annotationAttributes.getStringArray("scanBasePackage");
//            ClassPathScanningCandidateComponentProvider scanningCandidateComponentProvider = new CustomCandidateComponentScan(false);
//            scanningCandidateComponentProvider.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
//            for (String path : scanPaths) {
//                Set<BeanDefinition> candidateComponents = scanningCandidateComponentProvider.findCandidateComponents(path);
//                beanDefinitions.addAll(candidateComponents);
//            }
            CustomScan customScan = new CustomScan(registry);
            customScan.registerFilters();
            customScan.scan(scanPaths);

        }
//        beanDefinitions.forEach(item->{
//            GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) item;
//            genericBeanDefinition.setBeanClass(BeanProxy.class);
//            genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(genericBeanDefinition.getBeanClassName());
//            registry.registerBeanDefinition(item.getBeanClassName(), genericBeanDefinition);
//        });
    }

    static class CustomCandidateComponentScan extends ClassPathScanningCandidateComponentProvider{
        public CustomCandidateComponentScan(boolean useDefaultFilters) {
            super(useDefaultFilters);
        }

        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
            return beanDefinition.getMetadata().isInterface();
        }
    }
}
