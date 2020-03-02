/**
 * 
 */
package com.application.first.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class acts as the DTO Layer for <b>R5Organization</b> class.
 * 
 * @version 1.0
 *
 */
@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrganizationDTO {

	private String orgCode ;
}
