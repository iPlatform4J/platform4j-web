package com.platform4j.web.remote.impl;

import com.platform4j.soa.api.HelloService;
import com.platform4j.soa.domain.hello.Hello;
import com.platform4j.web.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloRemoteImpl implements HelloRemote {

    @Autowired
    private HelloService helloService;

    public Hello sayHello(String hello){
        return helloService.sayHello(hello);
    }
}
