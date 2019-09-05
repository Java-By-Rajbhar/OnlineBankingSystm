package com.ing.payeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.exception.RecordNotFoundException;
import com.ing.payeemanagement.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired

	FavoriteRepository repository;

	public List<FavoriteResponseDTO> getAllFavoriteAccounts(Integer pageNo, Integer pageSize) {

		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Favorite> pagedResult = repository.findAll(paging);

		List<FavoriteResponseDTO> pagedResultdto = new ArrayList<>();

		if (pagedResult.hasContent()) {
			for (Favorite favorite : pagedResult) {
				
				FavoriteResponseDTO favoriteResponseDTO = new FavoriteResponseDTO();
				favoriteResponseDTO.setAccountId(favorite.getFavoriteId());
				favoriteResponseDTO.setAccountName(favorite.getName());
				favoriteResponseDTO.setBankName(favorite.getBank());
				favoriteResponseDTO.setIban(favorite.getIban());
				pagedResultdto.add(favoriteResponseDTO);
			}

		}

		else {
			throw new RecordNotFoundException("Record Not Found");
		}
		return pagedResultdto;
	}

}
