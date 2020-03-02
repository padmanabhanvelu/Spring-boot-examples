/**
 * 
 */
package com.application.third.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class acts as the DTO Layer for <b>UserDetails</b> class.
 * 
 * @version 1.0
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class UserDetailsDTO {

	private Long userId;
	
	private String gssId;
	
	private String userName;
	
	private String emailId;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String isActive;
	
	private String role;
}
