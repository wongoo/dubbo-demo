package com.github.wongoo.dubbo.hello.controller;

import com.github.wongoo.dubbo.hello.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wongoo
 */
@RestController
public class HelloController {

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private HelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello() {
        return helloService.sayHello("world");
    }
}
