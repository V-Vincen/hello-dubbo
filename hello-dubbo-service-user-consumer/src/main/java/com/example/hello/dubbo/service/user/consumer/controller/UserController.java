package com.example.hello.dubbo.service.user.consumer.controller;

import com.example.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(version = "${user.service.version}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hystrixError")
    @RequestMapping(value = "/hi")
    public String sayHi() {
        return userService.sayHi();
    }

    /**
     * 熔断方法
     * @return
     */
    public String hystrixError() {
        return "Hystrix fallback";
    }

}
