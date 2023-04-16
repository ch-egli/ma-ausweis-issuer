package ch.sbb.iam.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/api/issuer/issue-request-callback").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/issuer/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(withDefaults());
        return http.build();
    }

}
