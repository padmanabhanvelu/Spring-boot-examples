package com.demo.emp.resource;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.emp.dto.EmployeeDTO;
import com.demo.emp.service.EmployeeService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeeController.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService service;

	
	@Test
	public void getEmployeesTest() throws Exception {

		EmployeeDTO alex = new EmployeeDTO(1L, "test", 500L, "test");

		List<EmployeeDTO> allEmployees = Arrays.asList(alex);

		given(service.getEmployeeDetails()).willReturn(allEmployees);

		mvc.perform(MockMvcRequestBuilders.get("/employee/getAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", Is.is(alex.getName())));
	}

	@Test
	public void getEmployeeByIdTest() throws Exception {

		EmployeeDTO emp = new EmployeeDTO(1L, "test", 500L, "test");

		given(service.getEmployeeById(1)).willReturn(emp);

		mvc.perform(MockMvcRequestBuilders.get("/employee/getById/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", Is.is(emp.getName())));
	}

	
	@Test
	public void saveEmployee() throws Exception {

		EmployeeDTO emp = new EmployeeDTO(1L, "test", 500L, "test");
		Gson gson = new Gson();
		String inputJson = gson.toJson(emp);
		given(service.saveEmployee(emp)).willReturn(emp);

		mvc.perform(MockMvcRequestBuilders.post("/employee/save").contentType(MediaType.APPLICATION_JSON)
				.content(inputJson))
				.andExpect(status().isOk());
				
		
	}
	
	@Test
	public void deleteEmployeeTest() throws Exception {

		given(service.deleteEmployee(1)).willReturn(true);

		mvc.perform(MockMvcRequestBuilders.delete("/employee/delete/1").contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Is.is("Deleted Succcessfully")));
		
	}

	/*
	 * @Test public void updateProduct() throws Exception { String uri =
	 * "/products/2"; Product product = new Product(); product.setName("Lemon");
	 * String inputJson = super.mapToJson(product); MvcResult mvcResult =
	 * mvc.perform(
	 * MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
	 * .content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * assertEquals(content, "Product is updated successsfully"); }
	 * 
	 * @Test public void deleteProduct() throws Exception { String uri =
	 * "/products/2"; MvcResult mvcResult =
	 * mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn(); int status =
	 * mvcResult.getResponse().getStatus(); assertEquals(200, status); String
	 * content = mvcResult.getResponse().getContentAsString(); assertEquals(content,
	 * "Product is deleted successsfully"); }
	 */

}