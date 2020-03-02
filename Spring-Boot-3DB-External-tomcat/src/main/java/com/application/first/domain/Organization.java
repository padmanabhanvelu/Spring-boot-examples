package com.application.first.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "R5ORGANIZATION")
public class Organization {

  @Id
  @Column(name = "ORG_CODE ")
  private String orgCode ;

  /*@Column(name = "name")
  private String name;*/

}
