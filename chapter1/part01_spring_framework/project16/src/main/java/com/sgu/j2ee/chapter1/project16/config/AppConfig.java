package com.sgu.j2ee.chapter1.project16.config;

import com.sgu.j2ee.chapter1.project16.scope.ThreadLocalScope;
import com.sgu.j2ee.chapter1.project16.service.MyBean;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();

        Map<String, Object> scopes = new HashMap<>();

       scopes.put("thread-local", new ThreadLocalScope());

        configurer.setScopes(scopes);

        return configurer;
    }
    @Bean
    @Scope("thread-local")
    public MyBean myBean() {
        return new MyBean();
    }
}
