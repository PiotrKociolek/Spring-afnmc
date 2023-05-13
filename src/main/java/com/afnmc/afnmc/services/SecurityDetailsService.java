package com.afnmc.afnmc.services;

import com.afnmc.afnmc.models.documets.UserDocument;
import com.afnmc.afnmc.repositories.UserRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityDetailsService implements UserDetailsService {
    private final UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserDocument byUsername = repo.findByEmail(username).get();

        return new User(byUsername.getEmail(), byUsername.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_" + byUsername.getPermissionType())));
    }
}
