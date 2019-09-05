package com.ing.payeemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.payeemanagement.dto.FavoriteDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.dto.ResponseDto;
import com.ing.payeemanagement.service.FavoriteService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })

public class FavoriteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteController.class);

	@Autowired
	private FavoriteService favoriteService;

	/**
	 * This method is use to get all the favorite accounts
	 * 
	 * @PathVariable customerId,not null
	 * @return ResponseEntity<List<FavoriteResponseDTO>>
	 */

	@GetMapping("/accounts/{customerId}")
	public ResponseEntity<List<FavoriteRequestDto>> getAllFavoriteAccounts(@PathVariable int customerId,
			@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize) {

		LOGGER.info("inside getAllFavoriteAccounts method of FavoriteController class");
		List<FavoriteRequestDto> list = favoriteService.getAllFavoriteAccounts(customerId, pageNo, pageSize);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	
	@PostMapping("/accounts")
	public ResponseEntity<ResponseDto> addFavorite(@Valid @RequestBody FavoriteDto favoriteDto) {

		LOGGER.info("FavoriteController :: addFavorite --");

		return new ResponseEntity<>(favoriteService.addFavorite(favoriteDto), HttpStatus.CREATED);
	}
}
