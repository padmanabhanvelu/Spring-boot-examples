package com.demo.emp;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.emp.domain.User;
import com.demo.emp.repo.UserRepo;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    ApplicationRunner init(UserRepo repository) {
        return (ApplicationArguments args) ->  dataSetup(repository);
    } 

	@Transactional
    public void dataSetup(UserRepo repository){
   
    	User user = new User(1,"Test","Test","Y");
    	user.setPassword(bCryptPasswordEncoder().encode("Test"));
    	repository.save(user);
    	System.out.println("USERS :"+repository.findAll());
    }

}
