package com.invillia.bank_account_springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class ClientDAOConfig {
    @Bean
    public ClientDAO clientDAO(final EntityManager entityManager){
        return new ClientDAOImpl(entityManager);
    }
}
