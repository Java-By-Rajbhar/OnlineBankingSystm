package com.ing.payeemanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.payeemanagement.dto.CustomerLoginResponse;
import com.ing.payeemanagement.dto.CustomerRequestdto;
import com.ing.payeemanagement.entity.Customer;
import com.ing.payeemanagement.exception.CredentialsInvalidException;
import com.ing.payeemanagement.repository.CustomerRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	CustomerRepository customerRepository;
    /**
     * This method is use to login for customer
     * @param customerRequestdto ,not null
     * @return CustomerLoginResponse,not null
     * @exception CredentialsInvalidException throws if customer id does not exits
     */
	@Override
	public CustomerLoginResponse customerLogin(CustomerRequestdto customerRequestdto) {
		LOGGER.info("Inside customerLogin method of CustomerServiceImpl class");
		Customer customer = customerRepository.findByCustomerId(customerRequestdto.getCustomerId());
		if(customer!=null)
		{
			CustomerLoginResponse loginResponse  = new CustomerLoginResponse();
			loginResponse.setCustomerName(customer.getCustomerName());
			loginResponse.setMessage("Login successfull");
			loginResponse.setStatus("success");
			loginResponse.setStatusCode(HttpStatus.OK.value());
			
			return loginResponse; 
		}
		else
		{
			throw new CredentialsInvalidException("Customer does not exist");
		}
	}

}
