package com.crus.Spring_Security_OAuth2_App.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/")
                        .permitAll()
                        .requestMatchers("/protected")
                        .authenticated()
                        .anyRequest()
                        .permitAll())
                .oauth2Login(Customizer.withDefaults())
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureUrl("/error")
                )
                .logout(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index"))
                .sessionManagement(session -> session
                        .maximumSessions(3)
                        .maxSessionsPreventsLogin(true)
                        .expiredUrl("/login?expired"));

        return http.build();
    }
}
