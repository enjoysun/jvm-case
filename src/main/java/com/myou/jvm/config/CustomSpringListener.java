package com.myou.jvm.config;

import com.myou.jvm.annotatuon.RpcReference;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @Author myou
 * @Date 2021/1/15  5:16 下午
 */
public class CustomSpringListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ClassPathScanningCandidateComponentProvider scanningCandidateComponentProvider = new ClassPathScanningCandidateComponentProvider(false);
        scanningCandidateComponentProvider.addIncludeFilter(new AnnotationTypeFilter(RestController.class));
//        String scanPackage = String.format("%s/%s/%s", ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX,"com", "**/*.class");
        Set<BeanDefinition> candidateComponents = scanningCandidateComponentProvider.findCandidateComponents("com");
        System.out.println("ok");
    }

    static class CustomFilter implements TypeFilter {

        @Override
        public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
            Class<? extends MetadataReader> aClass = metadataReader.getClass();
            Field[] fields = aClass.getFields();
            for (Field field : fields
            ) {
                RpcReference annotation = field.getAnnotation(RpcReference.class);
                if (annotation != null)
                    return true;
            }
            return false;
        }
    }
}
