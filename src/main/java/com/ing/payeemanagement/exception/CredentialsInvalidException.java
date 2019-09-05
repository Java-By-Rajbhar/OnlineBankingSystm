package com.ing.payeemanagement.exception;
/**
 * 
 * @author Sushil
 *
 */
public class CredentialsInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CredentialsInvalidException(String message)
	{
		super(message);
	}

}
