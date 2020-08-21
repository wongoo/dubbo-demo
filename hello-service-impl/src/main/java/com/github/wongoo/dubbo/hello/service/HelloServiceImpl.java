package com.github.wongoo.dubbo.hello.service;

import com.github.wongoo.dubbo.hello.HelloService;
import com.github.wongoo.dubbo.hello.Request;
import com.github.wongoo.dubbo.hello.Response;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author wongoo
 */
@DubboService(version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        logger.info("hello request from {}:{}",
                RpcContext.getContext().getRemoteHost(),
                RpcContext.getContext().getRemotePort());
        return String.format("[%s] : Hello, %s, Response from %s",
                serviceName,
                name,
                RpcContext.getServerContext().getLocalAddressString()
        );
    }

    @Override
    public Response exchange(Request request) {
        logger.info("exchange received from {}:{} -> {}, {}, {}",
                RpcContext.getContext().getRemoteHost(),
                RpcContext.getContext().getRemotePort(),
                request.getTime(),
                request.getId(),
                request.getContent());
        Response response = new Response();
        response.setRequestId(request.getId());
        response.setResult(String.format("ok, I have received your request: %s, time: %s",
                request.getContent(),
                request.getTime()));
        return response;
    }
}
