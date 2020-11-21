package com.platform4j.web.webapp.Launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@EnableAsync
@ComponentScan(basePackages={"com.platform4j.web"})
@ImportResource(locations={
        "classpath:applicationContext-resources.xml",
        "classpath:applicationContext-aop.xml",
        "classpath:dubbo-consumer.xml"
})
public class Launcher {

    private static ApplicationContext ctx;
    private static volatile boolean running = true;
    public static void main(String[] args) {

        try {
            ctx = SpringApplication.run(Launcher.class, args);
        }catch (Throwable e){
            e.printStackTrace();
            running = false;
        }

        synchronized(Launcher.class) {
            while(running) {
                try {
                    Launcher.class.wait();
                } catch(Throwable e) {
                }
            }
        }
    }
}
