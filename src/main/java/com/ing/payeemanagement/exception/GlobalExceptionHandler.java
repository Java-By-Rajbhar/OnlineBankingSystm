package com.ing.payeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Sushil
 *
 */
@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CredentialsInvalidException.class)
	public ResponseEntity<ErrorResponse> credentialsInvalidExceptionHandler(CredentialsInvalidException ex)
	{
		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), "fail");
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> RecordNotFoundExceptionHandler(RecordNotFoundException ex)
	{
		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), "fail");
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	

	

}
