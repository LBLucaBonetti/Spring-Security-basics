package it.lbsoftware.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/") // Allow the index.html aka the root of your website
                                .permitAll()
                                .anyRequest() // Any other request will be required to be authenticated
                                .authenticated()
                )
                .formLogin(withDefaults()); // We want an automatic login form so that we do not need to build one

        // Some important facts:
        // 1. Spring Security enables CSRF protection by default for "unsafe" HTTP methods like POST, PUT and DELETE
        // 2. User credentials are stored in application.properties for this example; DO NOT USE THIS APPROACH IN PRODUCTION

        return http.build();
    }

}
