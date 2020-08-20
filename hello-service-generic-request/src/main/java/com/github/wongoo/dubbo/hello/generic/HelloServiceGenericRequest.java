package com.github.wongoo.dubbo.hello.generic;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author wongoo
 */
public class HelloServiceGenericRequest {

    public static void main(String[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setUrl("dubbo://127.0.0.1:12345");
        HelloServiceGeneric.callHelloService(reference, "hello-service-generic");
    }
}
