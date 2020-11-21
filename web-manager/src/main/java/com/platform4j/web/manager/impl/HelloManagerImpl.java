package com.platform4j.web.manager.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.platform4j.soa.domain.hello.Hello;
import com.platform4j.web.manager.HelloManager;
import com.platform4j.web.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloManagerImpl implements HelloManager {

    @Autowired
    private HelloRemote helloRemote;

    public String sayHello(String hello){
        String result = "";
        Hello resultR = helloRemote.sayHello(hello);
        try{
            result = JSON.json(resultR);
        }catch(Exception e){
        }
        return result;
    }
}
