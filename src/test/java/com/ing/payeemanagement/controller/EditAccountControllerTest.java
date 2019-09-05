package com.ing.payeemanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.payeemanagement.dto.DeletedResponseDto;
import com.ing.payeemanagement.dto.FavoriteEditResponseDto;
import com.ing.payeemanagement.dto.FavoriteRequestDto;
import com.ing.payeemanagement.service.EditFavoriteAccountServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class EditAccountControllerTest {
	
	@Mock
	EditFavoriteAccountServiceImpl editFavoriteAccountServiceImpl;
	
	@InjectMocks
	EditAccountController editAccountController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(editAccountController).build();
	}

	@Test
	public void testEdit() throws JsonProcessingException, Exception {

		FavoriteRequestDto favoriteRequestDto=new FavoriteRequestDto();
		
		favoriteRequestDto.setAccountId(1);
		favoriteRequestDto.setAccountName("Shashank Kumar");
		favoriteRequestDto.setBankName("Nairobi Bank");
		favoriteRequestDto.setIban("ES211234123423453456");
		
		FavoriteEditResponseDto favoriteEditResponseDto=new FavoriteEditResponseDto();
		favoriteEditResponseDto.setMessage("Updated Succesfully");
		favoriteEditResponseDto.setStatus("Success");
		favoriteEditResponseDto.setStatusCode(200);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/accounts").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(favoriteRequestDto))).andReturn();
		
		when(editFavoriteAccountServiceImpl.edit(Mockito.any())).thenReturn(favoriteEditResponseDto);
		
		ResponseEntity<FavoriteEditResponseDto> actual=editAccountController.edit(favoriteRequestDto);
		assertEquals(200, actual.getBody().getStatusCode());
				
	
	}

	@Test
	public void testDelete() throws JsonProcessingException, Exception {

		
		DeletedResponseDto deletedResponseDto=new DeletedResponseDto();
		deletedResponseDto.setMessage("Deleted SuccessFully");
		deletedResponseDto.setStatus("Success");
		deletedResponseDto.setStatusCode(200);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(""))).andReturn();
		
	    when(editFavoriteAccountServiceImpl.delete(Mockito.anyInt())).thenReturn(deletedResponseDto);
	    ResponseEntity<DeletedResponseDto> actual=editAccountController.delete(1);
	    assertEquals(200, actual.getBody().getStatusCode());
	
	}

}
