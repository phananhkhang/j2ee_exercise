package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        // Ai cũng được xem trang chủ, login và CSS
                        .requestMatchers(
                                "/",
                                "/login",
                                "/css/**")
                        .permitAll()

                        // Các URL khác phải đăng nhập
                        .anyRequest()
                        .authenticated())

                .formLogin(form -> form

                        // Trang đăng nhập của chúng ta
                        .loginPage("/login")

                        // Sau khi đăng nhập thành công
                        .defaultSuccessUrl("/books", true)

                        .permitAll())

                .logout(logout -> logout

                        .logoutSuccessUrl("/")

                        .permitAll());

        return http.build();
    }
}