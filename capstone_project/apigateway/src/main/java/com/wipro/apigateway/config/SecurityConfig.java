package com.wipro.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(exchange -> exchange
                // 👇 Public endpoints
                .pathMatchers("/user/register", "/user/login").permitAll()
                .pathMatchers("/admin/products/**", "/customer/products/**").permitAll()
                .pathMatchers("/orders/**").permitAll()
                .pathMatchers("/carts/**").permitAll()
                
                // 👇 Everything else requires auth
                .anyExchange().authenticated()
            )
            .build();
    }
}