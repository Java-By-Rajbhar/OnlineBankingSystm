package com.ing.payeemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

	private String message;
	private Integer statusCode;
	private String status;
}
