package com.yzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/16  17:59
 */
@SpringBootApplication
//        (exclude= {DataSourceAutoConfiguration.class})
public class PageHelperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageHelperApplication.class, args);
    }
}
