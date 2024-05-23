package com.yzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * description:
 *
 * @author yzm
 */
@SpringBootApplication
public class SpringBootTestApplication {
    public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootTestApplication.class, args);
    }
}
