package com.application.configuration;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory",
    transactionManagerRef = "secondTransactionManager", basePackages = {"com.application.second.repo"})
public class SecondDbConfig {
	
	
	@Autowired
    private Environment env;

  @Bean(name = "secondDataSource")
  //@ConfigurationProperties(prefix = "second.datasource")
  public DataSource secondDataSource() throws NamingException {
    //return DataSourceBuilder.create().build();
	  return (DataSource) new JndiTemplate().lookup(env.getProperty("second.datasource.jndi-name"));    
  }
  
  @Bean(name = "secondEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("secondDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.flex.baan.application.second.domain").persistenceUnit("secondPU")
        .build();
  }

  @Bean(name = "secondTransactionManager")
  public PlatformTransactionManager secondTransactionManager(
      @Qualifier("secondEntityManagerFactory") EntityManagerFactory secondEntityManagerFactory) {
    return new JpaTransactionManager(secondEntityManagerFactory);
  }

}
