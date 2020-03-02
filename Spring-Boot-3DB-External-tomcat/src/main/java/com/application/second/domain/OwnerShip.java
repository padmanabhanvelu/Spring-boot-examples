package com.application.second.domain;

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
@Table(name = "OWNERSHIP")
public class OwnerShip {

  @Id
  @Column(name = "OWN_CODE ")
  private String ownerCode ;

  @Column(name = "name")
  private String name;

}
