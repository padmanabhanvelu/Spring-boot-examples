/**
 * 
 */
package com.application.third.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.third.domain.UserDetails;

/**
 * This interface acts as the Repository layer for UserDetails.
 * 
 * @version 1.0
 *
 */
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	UserDetails findByEmailId(String emailId);

	List<UserDetails> findByCreatedBy(String userName);

	
}
