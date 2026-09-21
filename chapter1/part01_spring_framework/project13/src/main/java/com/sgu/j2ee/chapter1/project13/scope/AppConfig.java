package com.sgu.j2ee.chapter1.project13.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.sgu.j2ee.chapter1.project13.scope")
public class AppConfig {
    @Bean
    @Scope(value = "singleton")
    public MessageService messageService() {
        return new TwitterMessageService();
    }
}
