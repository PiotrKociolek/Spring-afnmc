package com.afnmc.afnmc.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
