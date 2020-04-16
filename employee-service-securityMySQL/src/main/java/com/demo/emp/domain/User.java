package com.demo.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
 
   
    @Column(nullable = false, unique = true)
    private String username;
 
    private String password;
    
    @Id
    @Column(nullable = false, unique = true)
    private String emailId;
 
   
}