package com.afnmc.afnmc.utilities;

import com.afnmc.afnmc.models.dtos.response.UserJWT;
import com.afnmc.afnmc.services.SecurityDetailsService;
import com.afnmc.afnmc.utilities.jwt.JwtTokenEncoder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class TokenAuthenticationFilter extends BasicAuthenticationFilter {
    private final JwtTokenEncoder tokenEncoder;
    private final SecurityDetailsService detailsService;

    public TokenAuthenticationFilter(final AuthenticationManager authenticationManager, final JwtTokenEncoder jwtTokenUtility, final SecurityDetailsService detailsService) {
        super(authenticationManager);
        this.tokenEncoder = jwtTokenUtility;
        this.detailsService = detailsService;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final String authorization = request.getHeader("Authorization");

        if (!tokenEncoder.isTokenValid(authorization)) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuth(authorization));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuth(final String authorization) {

        final UserJWT tokenModel = tokenEncoder.getTokenModel(authorization);
        final String user = tokenModel.getEmail();
        final UserDetails userDetails = detailsService.loadUserByUsername(user);
        final Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }
}
