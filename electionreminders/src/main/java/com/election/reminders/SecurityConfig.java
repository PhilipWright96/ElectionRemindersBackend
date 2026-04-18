package com.election.reminders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Bean
    @Order(1)
    public SecurityFilterChain adminSecurity(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/admin/**")
                // Switch off csrf since we don't use cookies anyway
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().hasRole("ADMIN"))
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dashboard/**").hasRole("ADMIN")
                        .anyRequest().permitAll())
                .formLogin(form -> form
                        .permitAll());

        return http.build();
    }

    @Bean
    @Order(3)
    public SecurityFilterChain publicSecurity(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username(adminUsername)
                .password(passwordEncoder().encode(adminPassword))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}