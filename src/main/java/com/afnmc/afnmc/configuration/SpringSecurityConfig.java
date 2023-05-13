package com.afnmc.afnmc.configuration;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.afnmc.afnmc.services.SecurityDetailsService;
import com.afnmc.afnmc.utilities.TokenAuthFilter;
import com.afnmc.afnmc.utilities.TokenAuthenticationFilter;
import com.afnmc.afnmc.utilities.jwt.JwtTokenEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig {
  private final AuthenticationConfiguration authenticationConfiguration;
  private final JwtTokenEncoder jwtTokenEncoder;
  private final SecurityDetailsService securityDetailsService;

  @Bean
  public AuthenticationManager authManager() throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            chain ->
                chain
                    .requestMatchers("/swagger-ui/**")
                    .permitAll()
                    .requestMatchers(
                        GET, "/aircraft/**", "/airport/**", "/flight/**", "/ticket/**", "/user/**")
                    .hasRole("USER")
                    .requestMatchers(
                        DELETE,
                        "/aircraft/**",
                        "/airport/**",
                        "/flight/**",
                        "/ticket/**",
                        "/user/**")
                    .hasAnyRole("ADMIN", "ASSISTANT")
                    .requestMatchers(
                        PUT, "/aircraft/**", "/airport/**", "/flight/**", "/ticket/**", "/user/**")
                    .hasAnyRole("ADMIN", "ASSISTANT")
                    .requestMatchers(POST, "/user/**")
                    .anonymous()
                    .anyRequest()
                    .permitAll())
        .httpBasic(Customizer.withDefaults())
        .addFilter(new TokenAuthFilter(authManager(), jwtTokenEncoder))
        .sessionManagement()
        .sessionCreationPolicy(STATELESS)
        .and()
        .addFilterBefore(
            new TokenAuthenticationFilter(authManager(), jwtTokenEncoder, securityDetailsService),
            TokenAuthenticationFilter.class);
    return http.build();
  }
}
