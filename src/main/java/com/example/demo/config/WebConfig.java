package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/post")
//                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").permitAll()
                .and()
                .httpBasic()
        ;
    }
}
