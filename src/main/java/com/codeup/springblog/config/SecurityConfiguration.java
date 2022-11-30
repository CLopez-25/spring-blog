package com.codeup.springblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/","/posts", "/posts/{id}").permitAll()
                .antMatchers("/posts/create", "/posts/{id}/edit").authenticated()
            .and().formLogin()
            .and().httpBasic();

        return http.build();
    }

}
