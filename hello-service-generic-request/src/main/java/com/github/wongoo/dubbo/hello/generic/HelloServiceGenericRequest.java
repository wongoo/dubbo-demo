package com.github.wongoo.dubbo.hello.generic;

/**
 * @author wongoo
 */
public class HelloServiceGenericRequest extends AbstractHelloServiceGeneric {

    /**
     * hello-service-provider serve at port 12345
     * hello-service-provider-zk serve at port 12346
     * <p>
     * start the project hello-service-provider first
     */
    public static void main(String[] args) {
        configApplication("hello-service-generic");

        configReferenceBaseInfo();

        configReferenceUrl("dubbo://127.0.0.1:12346");

        initGenericService();

        callHelloService();
    }
}
