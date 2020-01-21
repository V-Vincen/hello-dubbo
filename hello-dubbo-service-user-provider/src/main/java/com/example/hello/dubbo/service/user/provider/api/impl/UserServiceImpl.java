package com.example.hello.dubbo.service.user.provider.api.impl;

import com.example.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.protocol.port}")
    private String port;

    /**
     * 配置阈值：Hystrix 是 2 秒 10 次（不配置 commandProperties 时，为默认 5 秒 10 次）
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public String sayHi() {
//        return "Hello Dubbo, i am from prot" + port;
        throw new RuntimeException("Exception to show hystrix enabled.");
    }

}
