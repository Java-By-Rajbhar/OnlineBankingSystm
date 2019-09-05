package com.ing.payeemanagement.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
}
