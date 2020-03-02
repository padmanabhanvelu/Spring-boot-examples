Project to demo multiple DB connection using external Tomcat datasource using jndi-name.

This project is developed with Springboot Framework
Three Oracle database connectivity using Spring Data JPA

step by step instruction

 external tomcat datasource and configured it.

1) created 3 datasource in <tomcat-directory>/conf/server.xml

	
	<Resource auth="Container" driverClassName="oracle.jdbc.OracleDriver" factory="org.apache.tomcat.jdbc.pool.DataSourceFactory" maxTotal="20" maxIdle="10" maxWaitMillis="-1" name="jdbc/firstDS" password="xxxxx" type="javax.sql.DataSource" url="<url1>" username="user1"/>
	
	<Resource auth="Container" driverClassName="oracle.jdbc.OracleDriver" factory="org.apache.tomcat.jdbc.pool.DataSourceFactory" maxTotal="20" maxIdle="10" maxWaitMillis="-1" name="jdbc/secondDS" password="xxxxx" type="javax.sql.DataSource" url="<url2>" username="user2"/>
	
	<Resource auth="Container" driverClassName="oracle.jdbc.OracleDriver" factory="org.apache.tomcat.jdbc.pool.DataSourceFactory" maxTotal="20" maxIdle="10" maxWaitMillis="-1" name="jdbc/thirdDS" password="xxxxx" type="javax.sql.DataSource" url="<url3>" username="user3"/>

2) Declare the same datasource in <tomcat-directory>/conf/context.xml

	<ResourceLink auth="Container" name="jdbc/firstDS" global="jdbc/firstDS" type="javax.sql.DataSource" />
	<ResourceLink auth="Container" name="jdbc/secondDS" global="jdbc/secondDS" type="javax.sql.DataSource" />
	<ResourceLink auth="Container" name="jdbc/thirdDS" global="jdbc/thirdDS" type="javax.sql.DataSource" />
	
3) Define the datasource jndi-name in the springboot properties file

spring.datasource.jndi-name=java:comp/env/jdbc/firstDS
second.datasource.jndi-name=java:comp/env/jdbc/secondDS
third.datasource.jndi-name=java:comp/env/jdbc/thirdDS

4) Define the spring boot DB configuration for all the 3 database and make sure you declare atleast 1 datasource as primary
	firstDBConfig.java,secondDBConfig.java,thirdDBConfig.java - Just change the jndi-name property and create 3 config class
		
	@Configuration
	@EnableTransactionManagement
	@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
		transactionManagerRef = "transactionManager",   basePackages = {"com.first.application.repo"})
	public class FirstDbConfig {
		
		@Autowired
		private Environment env;

	  @Primary
	  @Bean(name = "dataSource")
	  public DataSource dataSource() throws NamingException {
		  return (DataSource) new JndiTemplate().lookup(env.getProperty("spring.datasource.jndi-name"));
	  }

	  @Primary
	  @Bean(name = "entityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
		  EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.first.application.domain").persistenceUnit("eamPU")
			.build();
	  }
	  

	  @Primary
	  @Bean(name = "transactionManager")
	  public PlatformTransactionManager transactionManager(
		  @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	  }
	  
