/**
 * 
 */
package com.application.configuration;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class is for creating datasource for third Database.
 * 
 * @version 1.0
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "thirdEntityManagerFactory",
    transactionManagerRef = "thirdTransactionManager", basePackages = {"com.application.third.repo"})
public class ThirdDbConfig {
	
	@Autowired
    private Environment env;

	  @Bean(name = "thirdDataSource")
	  public DataSource thirdDataSource() throws NamingException {
	    return (DataSource) new JndiTemplate().lookup(env.getProperty("third.datasource.jndi-name"));  
	  }
	  
	  @Bean(name = "thirdEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean thirdEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("thirdDataSource") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.application.third.domain").persistenceUnit("thirdPU")
	        .build();
	  }

	  @Bean(name = "thirdTransactionManager")
	  public PlatformTransactionManager thirdTransactionManager(
	      @Qualifier("thirdEntityManagerFactory") EntityManagerFactory thirdEntityManagerFactory) {
	    return new JpaTransactionManager(thirdEntityManagerFactory);
	  }


}
