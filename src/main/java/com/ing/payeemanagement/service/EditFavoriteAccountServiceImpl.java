package com.ing.payeemanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.dto.FavoriteResponseDto;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.repository.FavoriteRepository;


@Service
public class EditFavoriteAccountServiceImpl implements EditFavoriteAccountService {

	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	/**
	 * This method take the parameter from and update the record of favorite account
	 * @param intput FavoriteRequestDto,input from user
	 * @param output FavoriteResponseDto ,success for failure
	 */
	@Override
	public FavoriteResponseDto edit(FavoriteRequestDto favoriteRequestDto) {

		
		FavoriteResponseDto favoriteResponseDto=new FavoriteResponseDto();
		Optional<Favorite> favoriteRepo=favoriteRepository.findById(favoriteRequestDto.getAccountId());
		Favorite favorite=new Favorite();
		if(favoriteRepo.isPresent())
		{
			favorite=favoriteRepo.get();
			favorite.setName(favoriteRequestDto.getAccountName());
			favorite.setBank(favoriteRequestDto.getBankName());
			favorite.setIban(favoriteRequestDto.getIban());
			favoriteRepository.save(favorite);
			favoriteResponseDto.setMessage("Updated Successfully");
			favoriteResponseDto.setStatus("Success");
			favoriteResponseDto.setStatusCode(200);
		}
		
		return favoriteResponseDto;
	}

}
