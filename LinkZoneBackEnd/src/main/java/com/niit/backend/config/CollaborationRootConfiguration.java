package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.backend.entity.Blog;
import com.niit.backend.entity.Comment;

@Configuration
@ComponentScan(basePackages = "com.niit.backend")
@EnableWebMvc
@EnableTransactionManagement
public class CollaborationRootConfiguration {
	
	/*
	 * Database configuration
	 * */
	
	@Bean
	public DataSource getDataSource() {		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// oracle.jdbc.driver.OracleDriver
		dataSource.setDriverClassName("org.h2.Driver");
		// jdbc:oracle:thin:@localhost:1521:xe
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/collaboration");
		// system
		dataSource.setUsername("sa");
		// 
		dataSource.setPassword("");
		return dataSource;
	}
	

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);		
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Comment.class);
		return sessionBuilder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {		
		Properties properties = new Properties();
		// org.hibernate.dialect.OracleDialect
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	} 
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;				
	}
		
}
