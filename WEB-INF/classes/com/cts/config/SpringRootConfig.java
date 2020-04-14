package com.cts.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.cts"})
public class SpringRootConfig {
	
	//TODO:Services,DAO,DataSource,Email Sender etc
	@Bean
	public BasicDataSource getDataSource(){
		
		BasicDataSource ds =new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/e-loandb");
		ds.setUsername("root");
		ds.setPassword("adm@123");
		ds.setDefaultAutoCommit(true);
		return ds;
		
	}

}
