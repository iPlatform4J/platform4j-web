package com.platform4j.web.webapp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author:
 * @create: 2019-07-11 21:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/applicationContext-resources.xml",
        "classpath:/applicationContext-redis.xml",
        "classpath:/applicationContext-aop.xml",
        "classpath:/dubbo-consumer.xml"
})
public class BaseTest {

    public static void main(String[] args) {
    }




}
