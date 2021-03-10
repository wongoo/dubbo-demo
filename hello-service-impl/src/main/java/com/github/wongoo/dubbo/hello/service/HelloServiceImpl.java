package com.github.wongoo.dubbo.hello.service;

import com.alibaba.fastjson.JSONObject;
import com.github.wongoo.dubbo.hello.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    public Map<String, Object> sayHello(String name) {
        logger.info("hello request from {}:{}",
                RpcContext.getContext().getRemoteHost(),
                RpcContext.getContext().getRemotePort());
        Map<String, Object> mapDemo = new AccessMap();
        BigDecimal decimal = new BigDecimal("100");
        mapDemo.put("test_BigDecimal",decimal);
        //return uid + System.currentTimeMillis();[
        return mapDemo;
    }

    @Override
    public TestJsonObject testResponseJsonData(String name) {
        logger.info("hello request from {}:{}",
                RpcContext.getContext().getRemoteHost(),
                RpcContext.getContext().getRemotePort());
        TestJsonObject t = new TestJsonObject();
        t.ob = new JSONObject();
        BigDecimal decimal = new BigDecimal("100");
        Map<String, Object> mapDemo = new AccessMap();
        //放进去decimal之后就会报错
        t.ob.put("test_BigDecimal",decimal);
        t.ob.put("test_string", "123");
        t.ob.put("test_int", 123);
        t.ob.put("test_float", 123F);
        t.ob.put("test_long", 123L);
        t.ob.put("test_double", 123D);
        t.ob.put("test_map", mapDemo);
        return t;
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
