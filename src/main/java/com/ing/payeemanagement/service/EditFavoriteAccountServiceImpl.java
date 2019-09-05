package com.ing.payeemanagement.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.payeemanagement.controller.CustomerLoginController;
import com.ing.payeemanagement.dto.DeletedResponseDto;
import com.ing.payeemanagement.dto.FavoriteEditResponseDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.exception.RecordNotFoundException;
import com.ing.payeemanagement.repository.FavoriteRepository;


@Service
public class EditFavoriteAccountServiceImpl implements EditFavoriteAccountService {

	private static final Logger LOGGER  = LoggerFactory.getLogger(EditFavoriteAccountServiceImpl.class);
	
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	/**
	 * This method take the parameter from and update the record of favorite account
	 * @param intput FavoriteRequestDto,not null
	 * @return FavoriteEditResponseDto,not null
	 * @exception RecordNotFoundException if recorn not found
	 */
	@Override
	public FavoriteEditResponseDto edit(FavoriteRequestDto favoriteRequestDto) {

		LOGGER.info("EditFavoriteAccountServiceImpl edit()");
		FavoriteEditResponseDto favoriteResponseDto=new FavoriteEditResponseDto();
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
		else
		{
			throw new RecordNotFoundException("No records Found");
		}
		
		return favoriteResponseDto;
	}

	/**
	 * This method take the parameter from and delete the record of favorite account
	 * @param intput integer
	 * @return DeletedResponseDto,not null
	 * @exception RecordNotFoundException if recorn not found
	 */
	@Override
	public DeletedResponseDto delete(int accountId) {
		
		LOGGER.info("EditFavoriteAccountServiceImpl delete()");
		DeletedResponseDto deletedResponseDto=new DeletedResponseDto();
		Optional<Favorite> favoriteRepo=favoriteRepository.findById(accountId);
		Favorite favorite=new Favorite();
		if(favoriteRepo.isPresent())
		{
			favorite=favoriteRepo.get();
			if(favorite.getStatus()==1)
			{
			favorite.setStatus(0);
			favorite.setExpiryDate(LocalDate.now());
			favoriteRepository.save(favorite);
			deletedResponseDto.setMessage("Deleted Successfully");
			deletedResponseDto.setStatus("Success");
			deletedResponseDto.setStatusCode(200);
			}
			else
			{
				throw new RecordNotFoundException("No records Found");
			}
		}
		else
		{
			throw new RecordNotFoundException("No records Found");
		}

		
		return deletedResponseDto;
	}

}
