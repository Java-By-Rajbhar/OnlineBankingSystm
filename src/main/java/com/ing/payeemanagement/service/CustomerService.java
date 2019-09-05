package com.ing.payeemanagement.service;

import com.ing.payeemanagement.dto.CustomerLoginResponse;
import com.ing.payeemanagement.dto.CustomerRequestdto;

/**
 * 
 * @author Sushil
 *
 */
public interface CustomerService {
	
	public CustomerLoginResponse customerLogin(CustomerRequestdto customerRequestdto);

}
