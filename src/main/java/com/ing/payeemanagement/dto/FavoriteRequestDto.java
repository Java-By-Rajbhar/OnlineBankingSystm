package com.ing.payeemanagement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Shashank
 *
 */

@Getter
@Setter
public class FavoriteRequestDto {

	private int accountId;
	private String accountName;
	private String iban;
	private String bankName;
	private Integer customerId;
	
	
}


