package com.github.wongoo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this project start dubbo service at port 12345, not use registry
 * <p>
 * see application.properties
 *
 * @author wongoo
 */
@SpringBootApplication
public class HelloServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloServiceProviderApplication.class, args);
    }
}
