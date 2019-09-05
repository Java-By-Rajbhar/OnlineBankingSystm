package com.ing.payeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.service.FavoriteService;
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = {"*","/"},origins = {"*","/"} )

public class FavoriteController {

	@Autowired
	FavoriteService favoriteservice;

	@GetMapping("/accounts")
	public ResponseEntity<List<FavoriteResponseDTO>> getAllFavoriteAccounts(
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize) {
		List<FavoriteResponseDTO> list = favoriteservice.getAllFavoriteAccounts(pageNo, pageSize);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
