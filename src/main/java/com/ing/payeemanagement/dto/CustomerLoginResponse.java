package com.ing.payeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class CustomerLoginResponse {
	
	private String message;
	private int statusCode;
	private String status;
	private String customerName;
	private int customerId;

}
