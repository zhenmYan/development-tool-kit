package com.yzm.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/16  20:04
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageInterceptor pageInterceptor(){
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        properties.setProperty("reasonable","true");
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
