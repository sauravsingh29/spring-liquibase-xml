package com.ss.poc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquiBaseConfiguration {
	
	@Autowired
	LiquibaseProperties properties;
	
	@Bean
	public SpringLiquibase liquibase() {
	    SpringLiquibase liquibase = new SpringLiquibase();
	    properties.setChangeLog("classpath:liquibase/master/db.changelog-master.xml");
	    liquibase.setChangeLog(this.properties.getChangeLog());
	    liquibase.setContexts(this.properties.getContexts());
	    liquibase.setDataSource(getDataSource());
	    liquibase.setDefaultSchema(this.properties.getDefaultSchema());
	    liquibase.setDropFirst(this.properties.isDropFirst());
	    liquibase.setShouldRun(this.properties.isEnabled());
	    return liquibase;
	}
	
	@Bean
	public DataSource getDataSource(){
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:testdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
}
