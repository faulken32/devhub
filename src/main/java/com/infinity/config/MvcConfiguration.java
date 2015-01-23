package com.infinity.config;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.infinity.controller"})
@EnableSpringDataWebSupport
@EnableJpaRepositories("com.infinity.data.jpa.service")
@Import({ SecurityConfig.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter {
        
    private static final List<String> DEFAULT_TILES_DEFINITIONS = new LinkedList<> ();
    static 
    {
        
        DEFAULT_TILES_DEFINITIONS.add("/WEB-INF/tiles.xml");
        DEFAULT_TILES_DEFINITIONS.add("/WEB-INF/view.xml");
    }
    
    
    @Bean(name="dataSopurce")
    public DataSource dataSource() {

        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/devhub?zeroDateTimeBehavior=convertToNull");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;

    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        
        InstrumentationLoadTimeWeaver instrumentationLoadTimeWeaver = new InstrumentationLoadTimeWeaver();
        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setLoadTimeWeaver(instrumentationLoadTimeWeaver);
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.infinity.data.jpa.domain");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        
        
        return factory.getObject();

    }
    
    
    @Bean 
    public JpaTransactionManager transactionManager(){
        
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        
        
        return jpaTransactionManager;
    
    }

   

    
    
    @Bean
    public TilesViewResolver tilesViewResolver(){
    
        return new TilesViewResolver();
    }
    
     @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean 
    public TilesConfigurer tilesConfigurer(){
    
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(DEFAULT_TILES_DEFINITIONS.toArray(new String[DEFAULT_TILES_DEFINITIONS.size()]));
        
        return  tilesConfigurer;
    }
}
