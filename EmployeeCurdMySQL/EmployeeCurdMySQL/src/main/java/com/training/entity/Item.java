package com.training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Item {
 
    @Id
    private Long id;
    private String color;
    private String grade;
    private String name;
     
    
}