package com.platform4j.web.webapp;

import com.platform4j.web.manager.HelloManager;
import com.platform4j.web.webapp.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {

    @Autowired
    private HelloManager helloManager;

    @RequestMapping("/test")
    public String test() {
        return "success";
    }

    @RequestMapping("/dubbo")
    public String hello(@RequestParam("word") String hello) {
        return helloManager.sayHello(hello);
    }
}
