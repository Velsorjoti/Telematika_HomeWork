package com.example.telematika_homework.config;

import com.example.telematika_homework.filter.UUIDAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UUIDAuthenticationFilter uuidAuthenticationFilter;

    public SecurityConfig(UUIDAuthenticationFilter uuidAuthenticationFilter) {
        this.uuidAuthenticationFilter = uuidAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain configureSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .anonymous()
                .and()
                .formLogin(form -> form
                        .loginPage("/login").permitAll())
                .httpBasic()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(uuidAuthenticationFilter, ExceptionTranslationFilter.class)
                .authorizeRequests()
                .anyRequest().authenticated();

        return httpSecurity.build();


    }
}
