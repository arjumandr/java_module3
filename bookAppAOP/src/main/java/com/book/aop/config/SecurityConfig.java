package com.book.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic();
		return http.build();
						
	}

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
		InMemoryUserDetailsManager mgr = new InMemoryUserDetailsManager();
		mgr.createUser(
				User.withUsername("student")
					.password("password")
					.roles("STUDENT")
					.build()
				);
		mgr.createUser(
				User.withUsername("teacher")
					.password("password")
					.roles("TEACHER")
					.build()
				);
		return mgr;
	}

    @Bean
    static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
