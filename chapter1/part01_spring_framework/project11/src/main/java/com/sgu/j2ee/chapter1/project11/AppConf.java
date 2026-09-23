package com.sgu.j2ee.chapter1.project11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {
    @Bean
    public GreetingService greetingService(){return new GreetingService("Xin chào Spring Boot từ file cấu hình AppConf!");}
}
