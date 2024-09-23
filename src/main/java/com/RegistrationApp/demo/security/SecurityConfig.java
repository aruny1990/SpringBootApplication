package com.RegistrationApp.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable() // For testing, disable CSRF
	            .authorizeRequests()
	            .requestMatchers("/api/register","/error").permitAll() // Allow public access to registration
	            .anyRequest().authenticated(); // Require authentication for all other requests
	            
	        return http.build();
	    }

	   
}
