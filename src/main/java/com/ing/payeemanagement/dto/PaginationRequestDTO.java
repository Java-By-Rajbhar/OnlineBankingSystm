package com.ing.payeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaginationRequestDTO {
	private int customerId;
	private int pageNo;
	private int pageSize;
	

}
