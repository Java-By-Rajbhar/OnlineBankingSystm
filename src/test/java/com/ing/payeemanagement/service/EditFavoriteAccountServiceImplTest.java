package com.ing.payeemanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.payeemanagement.dto.DeletedResponseDto;
import com.ing.payeemanagement.dto.FavoriteEditResponseDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.repository.FavoriteRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class EditFavoriteAccountServiceImplTest {

	@Mock
	FavoriteRepository favoriteRepository;
	
	
	@InjectMocks
	EditFavoriteAccountServiceImpl editFavoriteAccountServiceImpl;
	
	@Test
	public void testEdit() {
		
		Favorite favorite=new Favorite();
		favorite.setBank("Nairobi Bank");
		favorite.setCreatedDate(LocalDateTime.now());;
		favorite.setCustomerId(1234);
		favorite.setExpiryDate(LocalDate.of(2019, 10, 12));
		favorite.setFavoriteId(1);
		favorite.setIban("ES211234123412342345");
		favorite.setName("Shashank Kumar");
		favorite.setStatus(1);
		Optional<Favorite> optionalFav=Optional.of(favorite);
		
		FavoriteRequestDto favoriteRequestDto=new FavoriteRequestDto();
		favoriteRequestDto.setAccountId(1);
		favoriteRequestDto.setAccountName("shashank");
		favoriteRequestDto.setBankName("Moscow Bank");
		favoriteRequestDto.setIban("ES211234123412342346");
		
		
		when(favoriteRepository.findById(Mockito.anyInt())).thenReturn(optionalFav);
		FavoriteEditResponseDto actual=editFavoriteAccountServiceImpl.edit(favoriteRequestDto);
		
		assertEquals(200, actual.getStatusCode());
		
	}

	@Test
	public void testDelete() {
		Favorite favorite=new Favorite();
		favorite.setBank("Nairobi Bank");
		favorite.setCreatedDate(LocalDateTime.now());
		favorite.setCustomerId(1234);
		favorite.setExpiryDate(LocalDate.of(2019, 10, 12));
		favorite.setFavoriteId(1);
		favorite.setIban("ES211234123412342345");
		favorite.setName("Shashank Kumar");
		favorite.setStatus(1);
		Optional<Favorite> optionalFav=Optional.of(favorite);
		
		when(favoriteRepository.findById(Mockito.anyInt())).thenReturn(optionalFav);
		DeletedResponseDto actual=editFavoriteAccountServiceImpl.delete(1);
		assertEquals(200, actual.getStatusCode());
		
	}

}
