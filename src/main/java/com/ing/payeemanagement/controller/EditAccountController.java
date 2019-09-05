package com.ing.payeemanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.payeemanagement.dto.DeletedResponseDto;
import com.ing.payeemanagement.dto.FavoriteEditResponseDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.service.EditFavoriteAccountService;

@RestController
@RequestMapping("/api") 
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" }) 
public class EditAccountController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EditAccountController.class);
	
	@Autowired
	private EditFavoriteAccountService editFavoriteAccountService;
	
	@PutMapping("/accounts")
	public ResponseEntity<FavoriteEditResponseDto> edit(@RequestBody FavoriteRequestDto favoriteRequestDto)
	{
		
		return new ResponseEntity<>(editFavoriteAccountService.edit(favoriteRequestDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/accounts/{accountId}")
	public ResponseEntity<DeletedResponseDto> delete(@PathVariable int accountId)
	{
		return new ResponseEntity<>(editFavoriteAccountService.delete(accountId),HttpStatus.OK);
	}
	

}
