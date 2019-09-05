package com.ing.payeemanagement.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.payeemanagement.dto.CustomerLoginResponse;
import com.ing.payeemanagement.dto.CustomerRequestdto;
import com.ing.payeemanagement.service.CustomerServiceImpl;

/**
 * 
 * @author Sushil
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerLoginControllerTest {

	@Mock
	CustomerServiceImpl customerServiceImpl;
	
	@InjectMocks
	CustomerLoginController customerLoginController;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(customerLoginController).build();
	}
	
	@Test
	public void customerLoginTest() throws JsonProcessingException, Exception {
		CustomerRequestdto requestdto = new CustomerRequestdto();
		requestdto.setCustomerId(11011);
		CustomerLoginResponse response = new CustomerLoginResponse();
		response.setStatusCode(200);
		response.setCustomerName("Ram");
		Mockito.when(customerServiceImpl.customerLogin(Mockito.any())).thenReturn(response);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(requestdto))).andReturn();
		
		ResponseEntity<CustomerLoginResponse> response1  = customerLoginController.customerLogin(requestdto);
		
		assertEquals(200, response1.getStatusCodeValue());
		assertEquals("Ram", response1.getBody().getCustomerName());
		
	}
	

}
