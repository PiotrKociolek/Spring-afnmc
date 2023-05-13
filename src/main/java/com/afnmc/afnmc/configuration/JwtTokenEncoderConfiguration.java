package com.afnmc.afnmc.configuration;

import com.afnmc.afnmc.repositories.UserRepository;
import com.afnmc.afnmc.utilities.jwt.JwtTokenEncoder;
import com.afnmc.afnmc.utilities.jwt.JwtTokenEncoderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:jwtUtilities.properties")
public class JwtTokenEncoderConfiguration {
    private final UserRepository accountRepository;
    @Value("${encryption.vector:HSIEUT9SFFY9GJ5N}")
    String encryptionVector;
    @Value("${encryption.key:WD6C514FE9OZUQIR}")
    String encryptionKey;
    @Value("${token.expiry.days:30}")
    int tokenExpiryDays;

    @Bean
    JwtTokenEncoder getJwtTokenEncoder() {
        return new JwtTokenEncoderImpl(encryptionVector, encryptionKey, tokenExpiryDays, accountRepository);
    }
}
