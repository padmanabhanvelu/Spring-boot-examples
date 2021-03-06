package com.application.second.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.second.domain.TransactType;

@Repository
public interface TransactTypeRepository extends JpaRepository<TransactType, Long> {


}
