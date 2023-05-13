package com.afnmc.afnmc.configuration;

import com.afnmc.afnmc.services.SecurityDetailsService;
import com.afnmc.afnmc.utilities.TokenAuthFilter;
import com.afnmc.afnmc.utilities.TokenAuthenticationFilter;
import com.afnmc.afnmc.utilities.jwt.JwtTokenEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenEncoder jwtTokenEncoder;
    private final SecurityDetailsService securityDetailsService;

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        chain ->
                                chain.requestMatchers(GET, "/[CONTROLLER_PATH]/**")
                                        .hasRole("ADMINISTRATOR")
                                        .anyRequest()
                                        .permitAll())
                .httpBasic(Customizer.withDefaults())
                .addFilter(new TokenAuthFilter(authenticationManager, jwtTokenEncoder))
                .sessionManagement()
                .sessionCreationPolicy(STATELESS);
        http.addFilterBefore(
                new TokenAuthenticationFilter(
                        authenticationManager, jwtTokenEncoder, securityDetailsService),
                TokenAuthenticationFilter.class);
        return http.build();
    }
}
