package com.ing.payeemanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.payeemanagement.dto.CustomerLoginResponse;
import com.ing.payeemanagement.dto.CustomerRequestdto;
import com.ing.payeemanagement.service.CustomerService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders= {"*","/"},origins= {"*","/"})
public class CustomerLoginController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(CustomerLoginController.class);
	@Autowired
	CustomerService customerService;
	/**
	 * This method is use to login for customer
	 * @param customerRequestdto,not null
	 * @return ResponseEntity<CustomerLoginResponse>
	 */
	@PostMapping("/login")
	public ResponseEntity<CustomerLoginResponse> customerLogin(@RequestBody CustomerRequestdto customerRequestdto)
	{
		LOGGER.info("inside customerLogin method of CustomerLoginController class");
		CustomerLoginResponse response = customerService.customerLogin(customerRequestdto);
		return new ResponseEntity<CustomerLoginResponse>(response, HttpStatus.OK);
	}

}
