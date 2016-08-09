package com.ss.poc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import liquibase.integration.spring.SpringLiquibase;

//@Configuration
//@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquiBaseConfiguration {
	
	/*@Autowired
	LiquibaseProperties properties;
	
	@Bean
	public SpringLiquibase liquibase() {
	    SpringLiquibase liquibase = new SpringLiquibase();
	    liquibase.setChangeLog(this.properties.getChangeLog());
	    liquibase.setContexts(this.properties.getContexts());
	    liquibase.setDataSource(dataSource());
	    liquibase.setDefaultSchema(this.properties.getDefaultSchema());
	    liquibase.setDropFirst(this.properties.isDropFirst());
	    liquibase.setShouldRun(this.properties.isEnabled());
	    return liquibase;
	}
	

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;
    
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName(dataSourceDriverClassName);
        driverManagerDataSource.setUrl(dataSourceUrl);
        driverManagerDataSource.setUsername(dataSourceUsername);
        driverManagerDataSource.setPassword(dataSourcePassword);

        return driverManagerDataSource;
    }*/
}
