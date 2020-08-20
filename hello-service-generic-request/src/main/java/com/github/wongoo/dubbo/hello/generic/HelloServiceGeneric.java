package com.github.wongoo.dubbo.hello.generic;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author wongoo
 */
public class HelloServiceGeneric {

    public static void callHelloService(ReferenceConfig<GenericService> reference, String applicationName) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        ApplicationModel.getConfigManager().setApplication(applicationConfig);

        reference.setInterface("com.github.wongoo.dubbo.hello.HelloService");
        reference.setVersion("1.0.0");
        reference.setGeneric("true");

        GenericService genericService = reference.get();
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new String[]{"world"});
        System.out.println(result);
    }
}
