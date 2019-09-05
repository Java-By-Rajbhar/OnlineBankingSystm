package com.ing.payeemanagement.service;

import java.util.List;

import com.ing.payeemanagement.dto.FavoriteDto;
import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.dto.ResponseDto;

/**
 * @author Ajit
 *
 */
public interface FavoriteService {

	List<FavoriteResponseDTO> getAllFavoriteAccounts(Integer pageNo, Integer pageSize);

	ResponseDto addFavorite(FavoriteDto favoriteDto);

}
