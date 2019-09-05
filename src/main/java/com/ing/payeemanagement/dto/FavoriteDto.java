package com.ing.payeemanagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 *
 */
@Getter
@Setter
public class FavoriteDto {

	private Integer customerId;
	
	@NotBlank(message = "Name is Mandatory.")
	@Pattern(regexp = "^[a-zA-Z0-9 '-]*$", message = "Only Alpha-Numeric and ' & - is allowed.")
	private String name;
	
	@NotBlank(message = "IBAN is Mandatory.")
	@Size(max=20, min=20, message = "IBAN should be 20 charactors.")
	private String iban;
	private String bank;
	
}
