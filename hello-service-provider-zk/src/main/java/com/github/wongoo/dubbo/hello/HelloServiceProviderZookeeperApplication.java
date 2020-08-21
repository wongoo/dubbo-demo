package com.github.wongoo.dubbo.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this project start dubbo service at port 12346, use zookeeper registry zookeeper://127.0.0.1:2181
 * <p>
 * see application.properties
 *
 * @author wongoo
 */
@SpringBootApplication
public class HelloServiceProviderZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloServiceProviderZookeeperApplication.class, args);
    }
}
