package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // added this for swagger when spring security enabled
//        http.authorizeRequests()
//                .requestMatchers("/swagger-ui.html", "/v2/api-docs", "/swagger-resources/**", "/webjars/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();

//		1) All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//		2) If a request is not authenticated, a default web page is shown
        http.httpBasic(withDefaults());

//		3) CSRF -> POST, PUT   // csrf is disabled to allow post requests
        http.csrf().disable();


        return http.build();
    }
}
