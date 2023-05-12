package com.lecuong.springwebflux.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


/**
 * @author CuongLM18
 * @created 11/05/2023 - 8:59 AM
 * @project spring-webflux
 */
@Configuration
@EnableR2dbcRepositories
public class MapperConfig {

    @Bean
    public ModelMapper getMapper() {
        var mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}
