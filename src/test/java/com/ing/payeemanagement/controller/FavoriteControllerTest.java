package com.ing.payeemanagement.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import com.ing.payeemanagement.dto.CustomerRequestdto;
import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.service.FavoriteService;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteControllerTest {

	@Mock
	FavoriteService favoriteService;

	@InjectMocks
	FavoriteController favoriteController;
	private MockMvc mockMvc;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(favoriteController).build();
	}

	@Test
	public void getAllFavoriteAccountsTest() throws JsonProcessingException, Exception {

		CustomerRequestdto requestdto = new CustomerRequestdto();
		requestdto.setCustomerId(1);

		List<FavoriteResponseDTO> list = new ArrayList<>();
		FavoriteResponseDTO response = new FavoriteResponseDTO();
		response.setAccountId(1);
		response.setAccountName("Professor");
		response.setBankName("Nairobi");
		response.setIban("ES211234567878904567");
		list.add(response);

		Mockito.when(favoriteService.getAllFavoriteAccounts(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/accounts").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(requestdto))).andReturn();

		ResponseEntity<List<FavoriteResponseDTO>> response1 = favoriteController.getAllFavoriteAccounts(1, 0, 5);

		assertEquals(200, response1.getStatusCodeValue());
		assertEquals("Nairobi", response1.getBody().get(0).getBankName());

	}
}
