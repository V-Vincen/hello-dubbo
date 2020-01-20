package com.example.hello.dubbo.service.user.provider.api.impl;

import com.example.service.user.api.UserService;
import org.apache.dubbo.config.annotation.Service;


@Service(version="${user.service.version}")
public class UserServiceImpl implements UserService {

    @Override
    public String sayHi() {
        return "Hello Dubbo";
    }


}
