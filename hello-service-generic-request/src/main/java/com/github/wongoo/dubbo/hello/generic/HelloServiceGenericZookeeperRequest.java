package com.github.wongoo.dubbo.hello.generic;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author wongoo
 */
public class HelloServiceGenericZookeeperRequest {

    public static void main(String[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        reference.setRegistry(registryConfig);

        HelloServiceGeneric.callHelloService(reference, "hello-service-generic-zk");
    }
}
