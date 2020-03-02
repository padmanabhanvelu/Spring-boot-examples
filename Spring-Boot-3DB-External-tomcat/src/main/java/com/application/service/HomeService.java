/**
 * 
 */
package com.application.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.first.repo.OrganizationRepository;
import com.application.third.domain.UserDetails;
import com.application.third.dto.UserDetailsDTO;
import com.application.third.mapper.UserDetailsMapper;
import com.application.third.repo.UserDetailsRepository;

/**
 * This class acts as the service layer for <b>Home Controller</b> class.
 * 
 * @version 1.0
 *
 */
@Service
public class HomeService {

	private static final Logger log = LoggerFactory.getLogger(HomeService.class);

	

	private final OrganizationRepository organizationRepository;
	private final UserDetailsRepository userDetailsRepository;
	private final UserDetailsMapper userDetailsMapper;
	
	
	@Autowired
	public HomeService(OrganizationRepository organizationRepository,
			UserDetailsRepository userDetailsRepository,UserDetailsMapper userDetailsMapper) {
		this.organizationRepository = organizationRepository;
		this.userDetailsRepository = userDetailsRepository;
		this.userDetailsMapper =userDetailsMapper;
	}

	public List<UserDetailsDTO> getMyRequestsDetails(String userName) {
		log.info("Executing HomeService#getMyRequestsDetails()...");

		List<UserDetails> userDetails = userDetailsRepository.findByCreatedBy(userName);
		log.info("userDetails  List:: " + userDetails);

		List<UserDetailsDTO> userDetailsDTOs = userDetails.stream().map(userDetailsMapper::convertToDTO).collect(Collectors.toList());
		Collections.sort(userDetailsDTOs, Collections.reverseOrder());
		log.info("Transaction Details DTO List:: " + userDetailsDTOs);

		return userDetailsDTOs;
	}

	

	
}
