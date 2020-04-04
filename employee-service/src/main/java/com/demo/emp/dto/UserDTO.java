package com.demo.emp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6202994458349870709L;
	private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String status = "ACTIVE";
    private String application;
    private List<RoleDTO> roles = new ArrayList<>();
	
    
    
    @Override
	public String toString() {
		return "ApplicationUserDTO [id=" + id + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", status=" + status + ", application=" + application
				+ ", roles=" + roles + "]";
	}


    
}