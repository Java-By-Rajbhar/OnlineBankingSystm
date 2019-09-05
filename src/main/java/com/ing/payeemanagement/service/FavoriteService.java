package com.ing.payeemanagement.service;

import java.util.List;

import com.ing.payeemanagement.dto.FavoriteDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.dto.ResponseDto;

/**
 * @author Ajit
 *
 */
public interface FavoriteService {

	List<FavoriteRequestDto> getAllFavoriteAccounts(int customerId, Integer pageNo, Integer pageSize);

	ResponseDto addFavorite(FavoriteDto favoriteDto);

}
