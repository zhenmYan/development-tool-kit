package com.yzm.context;

import com.yzm.annotation.ComponentScan;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/29
 */
public class ApplicationContext {

    // 配置类的class文件
    private final Class config;

    public ApplicationContext(Class config){
        this.config = config;

        // 解析配置文件，注入bean对象
        ComponentScan annotation = (ComponentScan)config.getDeclaredAnnotation(ComponentScan.class);
        String path = annotation.value();
        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource("com/yzm/service");
        File file = new File(resource.getFile());
        System.out.println(file);

        System.out.println(path);
    }

    public Object getBean(String beanName){
        return null;
    }

}
