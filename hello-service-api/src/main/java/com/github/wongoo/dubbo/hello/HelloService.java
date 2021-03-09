package com.github.wongoo.dubbo.hello;

import java.util.Map;

/**
 * @author wongoo
 */
public interface HelloService {

    /**
     * say hello
     *
     * @param name user name
     * @return message
     */
    Map<String, Object> sayHello(String name);

    /**
     * exchange message
     *
     * @param request request message
     * @return response message
     */
    Response exchange(Request request);
}
