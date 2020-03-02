/**
 * 
 */
package com.application.third.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is the entity class that maps on to <b>USER_DETAILS</b> table.
 * 
 * @version 1.0
 *
 */
@Entity
@Table(name="USER_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UserDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="userDetailsSequence")
	@SequenceGenerator(name="userDetailsSequence", sequenceName="USER_DETAILS_SEQ", allocationSize=1)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="GSS_ID")
	private String gssId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="ROLE")
	private String role;
}
