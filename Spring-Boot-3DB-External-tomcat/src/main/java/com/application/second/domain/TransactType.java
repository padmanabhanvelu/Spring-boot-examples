package com.application.second.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TRANSACT_TYPE")
public class TransactType {

  @Id
  @Column(name = "TRANS_CODE")
  private String transCode;
  
  
  @Column(name = "TRANS_NAME")
  private String transName;

}
