package com.ing.payeemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.service.FavoriteService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })

public class FavoriteController {

	@Autowired
	FavoriteService favoriteservice;

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteController.class);

	/**
	 * This method is use to get all the favorite accounts
	 * 
	 * @PathVariable customerId,not null
	 * @return ResponseEntity<List<FavoriteResponseDTO>>
	 */

	@GetMapping("/accounts/{customerId}")
	public ResponseEntity<List<FavoriteResponseDTO>> getAllFavoriteAccounts(@PathVariable int customerId, @RequestParam(defaultValue = "1") Integer pageNo,@RequestParam(defaultValue = "5") Integer pageSize) {
	
		LOGGER.info("inside getAllFavoriteAccounts method of FavoriteController class");
		List<FavoriteResponseDTO> list = favoriteservice.getAllFavoriteAccounts(customerId, pageNo, pageSize);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
