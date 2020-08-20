package com.github.wongoo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wongoo
 */
@SpringBootApplication
@EnableAutoConfiguration
public class HelloServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceConsumerApplication.class, args);
    }

}