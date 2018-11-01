package com.buutcamp.config;

import com.buutcamp.dao.CountryDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name="countryDAO")
    @Scope("singleton")
    public CountryDAO getCountryDAO(){
        return new CountryDAO();
    }
}
