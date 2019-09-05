package com.ing.payeemanagement.service;

import java.util.List;

import com.ing.payeemanagement.dto.FavoriteResponseDTO;

public interface FavoriteService {


	List<FavoriteResponseDTO> getAllFavoriteAccounts(Integer pageNo, Integer pageSize);

}
