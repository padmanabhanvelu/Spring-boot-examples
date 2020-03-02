package com.application.second.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.second.domain.OwnerShip;

@Repository
public interface OwnerShipRepository extends JpaRepository<OwnerShip, String> {
	
	

}
