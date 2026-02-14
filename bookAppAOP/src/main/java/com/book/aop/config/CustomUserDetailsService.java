package com.book.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomUserDetailsService {

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails student = User.withUsername("student")
                .password("{noop}password")
                .roles("STUDENT")
                .build();

        UserDetails teacher = User.withUsername("teacher")
                .password("{noop}password")
                .roles("TEACHER")
                .build();

        return new InMemoryUserDetailsManager(student, teacher);
    }
    public static UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        if ("student".equals(username)) {
            return User.builder()
                    .username("student")
                    .password("{noop}password")
                    .roles("STUDENT")
                    .build();
        }

        if ("teacher".equals(username)) {
            return User.builder()
                    .username("teacher")
                    .password("{noop}password")
                    .roles("TEACHER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}