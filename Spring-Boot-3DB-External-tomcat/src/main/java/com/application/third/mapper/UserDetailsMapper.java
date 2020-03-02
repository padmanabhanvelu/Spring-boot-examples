package com.application.third.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import com.application.third.domain.UserDetails;
import com.application.third.dto.UserDetailsDTO;

@Service("userDetailsMapper")
public class UserDetailsMapper {

	public UserDetailsDTO convertToDTO(UserDetails userDetails) {
		ModelMapper modelMapper = configMapper();
		UserDetailsDTO dto = modelMapper.map(userDetails, UserDetailsDTO.class);
		return dto;
	}

	private ModelMapper configMapper() {
		ModelMapper mapper = new ModelMapper();
		PropertyMap<UserDetails, UserDetailsDTO> map = new PropertyMap<UserDetails, UserDetailsDTO>() {
			@Override
			protected void configure() {
				// skip().setCreatedBy(null);
				// skip().setCreatedByUser(null);
				// skip().setUpdatedByUser(null);
			}
		};
		mapper.addMappings(map);
		return mapper;
	}
	
}

