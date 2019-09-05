package com.ing.payeemanagement.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.payeemanagement.dto.FavoriteDto;
import com.ing.payeemanagement.dto.ResponseDto;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.repository.FavoriteRepository;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteServiceTest {

	@Mock
	private FavoriteRepository favoriteRepository;
	
	@InjectMocks
	private FavoriteServiceImpl favoriteServiceImpl;
	
	FavoriteDto favoriteDto = new FavoriteDto();
	List<Favorite> favorites = new ArrayList<>();
	Favorite favorite = new Favorite();
	ResponseDto responseDto = new ResponseDto();
	
	@Before
	public void setUp() {
		favoriteDto.setBankName("Bank of Ujjala");
		favoriteDto.setCustomerId(101);
		favoriteDto.setIban("SP201128192292922890");
		favoriteDto.setAccountName("Laxman verma");
		
		favorite.setBank("Bank of Ujjala");
		favorite.setCreatedDate(LocalDateTime.now());
		favorite.setCustomerId(101);
		favorite.setExpiryDate(LocalDate.now().plusYears(2));
		favorite.setFavoriteId(1010);
		favorite.setIban("SP201128192292922890");
		favorite.setName("Laxman verma");
		favorite.setStatus(1);
		
		responseDto.setMessage("Favorite Added successfully.");
		responseDto.setStatus("success");
		responseDto.setStatusCode(201);
//		favorites.add(favorite);
	}
	
	@Test
	public void testAddFavorit() {
		Mockito.when(favoriteRepository.findByCustomerId(Mockito.anyInt())).thenReturn(favorites);
		Mockito.when(favoriteRepository.save(Mockito.anyObject())).thenReturn(favorite);
		
		ResponseDto actualResponse = favoriteServiceImpl.addFavorite(favoriteDto);
		assertEquals("success", actualResponse.getStatus());
		
	}
}

