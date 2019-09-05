package com.ing.payeemanagement.service;

import com.ing.payeemanagement.dto.DeletedResponseDto;
import com.ing.payeemanagement.dto.FavoriteEditResponseDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;

public interface EditFavoriteAccountService {

	public FavoriteEditResponseDto edit(FavoriteRequestDto favoriteResponseDto);
	
	public DeletedResponseDto delete(int accountId);
	
}
