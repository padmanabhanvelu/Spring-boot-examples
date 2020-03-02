package com.application.configuration;

public class SecurityConfiguration{
}
/*@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("admin").password("welcome")
                .roles("USER", "ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/","/*","/*todo**").access("hasRole('USER')").and()
                .formLogin();
    }
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}*/