package com.ing.payeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteResponseDto {

	private int accountId;
	private String accountName;
	private String iban;
	private String bankName;

}
