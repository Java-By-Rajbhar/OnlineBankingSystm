package com.ing.payeemanagement.service;

import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.dto.FavoriteResponseDto;

public interface EditFavoriteAccountService {

	public FavoriteResponseDto edit(FavoriteRequestDto favoriteResponseDto);
	
}
