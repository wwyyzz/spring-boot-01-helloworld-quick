package com.wj.springboot.config;

import com.wj.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService(){

        System.out.println("add Bean...");
        return new HelloService();
    }
}
