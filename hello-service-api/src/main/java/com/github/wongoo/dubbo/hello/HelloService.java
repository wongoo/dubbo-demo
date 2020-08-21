package com.github.wongoo.dubbo.hello;

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
    String sayHello(String name);

    /**
     * exchange message
     *
     * @param request request message
     * @return response message
     */
    Response exchange(Request request);
}
