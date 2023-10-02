package com.formationspring.sncfchatp3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeHttpRequests(authorization->
                        authorization
                                .requestMatchers("/users").authenticated()
                                .requestMatchers("/roles").denyAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/login/read").permitAll()
                                .anyRequest().permitAll())

                .build();
    }


}
