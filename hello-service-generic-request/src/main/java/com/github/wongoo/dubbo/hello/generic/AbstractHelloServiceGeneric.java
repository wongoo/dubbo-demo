package com.github.wongoo.dubbo.hello.generic;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wongoo
 */
public abstract class AbstractHelloServiceGeneric {

    private static final int LOOP_TIME = 10;

    protected static  ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
    protected static GenericService genericService;

    public static void configApplication( String applicationName) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        ApplicationModel.getConfigManager().setApplication(applicationConfig);
    }

    public static void configReferenceBaseInfo() {
        reference.setInterface("com.github.wongoo.dubbo.hello.HelloService");
        reference.setVersion("1.0.0");
        reference.setGeneric("true");
    }

    public static void configReferenceUrl(String url) {
        reference.setUrl(url);
    }

    public static void configReferenceRegistry(String registry) {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registry);
        reference.setRegistry(registryConfig);
    }

    public static void initGenericService() {
        genericService = reference.get();
    }

    public static void callHelloService() {
        for (int i = 0; i < LOOP_TIME; i++) {
            onceCall();
        }
    }

    private static void onceCall() {
        sayHello();
        exchange();
    }

    private static void sayHello() {
        Object result = genericService.$invoke("sayHello",
                new String[]{"java.lang.String"},
                new String[]{"world"});

        System.out.println("sayHello: " + result);
    }

    private static final AtomicLong SEQUENCE = new AtomicLong();

    private static void exchange() {
        HashMap<String, Object> request = new HashMap<String, Object>(4);
        request.put("id", SEQUENCE.getAndIncrement());
        request.put("content", "hello generic");
        request.put("time", new Date());

        Object result = genericService.$invoke("exchange",
                new String[]{"com.github.wongoo.dubbo.hello.Request"},
                new Object[]{request});

        System.out.println("exchange: " + result);
    }
}
