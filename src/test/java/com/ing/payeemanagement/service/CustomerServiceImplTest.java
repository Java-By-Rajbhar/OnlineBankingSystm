package com.ing.payeemanagement.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.payeemanagement.dto.CustomerLoginResponse;
import com.ing.payeemanagement.dto.CustomerRequestdto;
import com.ing.payeemanagement.entity.Customer;
import com.ing.payeemanagement.repository.CustomerRepository;

/**
 * 
 * @author Sushil
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	
	@Mock
	CustomerRepository customerRepository;
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Test
	public void customerLoginTest()
	{
		CustomerRequestdto requestdto = new CustomerRequestdto();
		requestdto.setCustomerId(1001);
		
		Customer customer = new Customer();
		customer.setCustomerName("Ram");
		customer.setCustomerId(1001);
		Mockito.when(customerRepository.findByCustomerId(Mockito.anyInt())).thenReturn(customer);
		
		CustomerLoginResponse response = customerServiceImpl.customerLogin(requestdto);
		
		assertEquals(200, response.getStatusCode());
		assertEquals("success", response.getStatus());
		
	}
}
