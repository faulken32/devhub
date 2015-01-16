/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinityweb.devhub.data.jpa;

import ch.qos.logback.classic.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author faulken
 */
@Configuration
@EnableJpaRepositories("com.infinityweb.devhub.data.jpa.service")
@EnableTransactionManagement
public class JpaConfig {
    
    private final Logger LOGGER =  (Logger) LoggerFactory.getLogger(JpaConfig.class);
    
    @Bean
    public DataSource dataSource(){
        
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/devhub");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        
        
     return dataSource;
       
    }
    
    
}
