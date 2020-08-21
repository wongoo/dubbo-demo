package com.github.wongoo.dubbo.hello.generic;

/**
 * @author wongoo
 */
public class HelloServiceGenericZookeeperRequest extends AbstractHelloServiceGeneric {

    /**
     * start the project hello-service-provider-zk first
     */
    public static void main(String[] args) {
        configApplication("hello-service-generic-zk");

        configReferenceBaseInfo();

        configReferenceRegistry("zookeeper://127.0.0.1:2181");

        initGenericService();

        callHelloService();
    }
}
