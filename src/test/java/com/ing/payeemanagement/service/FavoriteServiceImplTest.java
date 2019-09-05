package com.ing.payeemanagement.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.entity.Customer;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.repository.CustomerRepository;
import com.ing.payeemanagement.repository.FavoriteRepository;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteServiceImplTest {

	@Mock
	CustomerRepository customerRepository;
	@Mock
	FavoriteRepository favoriteRepository;

	@InjectMocks
	FavoriteServiceImpl favoriteServiceImpl;

	@Test
	public void getAllFavoriteAccountsTest() {

		List<Favorite> list = new ArrayList<>();
		Favorite requestdto = new Favorite();
		requestdto.setBank("Nairobi");
		requestdto.setCreatedDate(LocalDate.now());
		requestdto.setCustomerId(1);
		requestdto.setExpiryDate(LocalDate.now());
		requestdto.setIban("ES21123478974563");
		requestdto.setFavoriteId(1);
		requestdto.setName("Professor");
		requestdto.setStatus(1);
		list.add(requestdto);

		Customer customer = new Customer();
		customer.setCustomerName("Professor");
		customer.setCustomerId(1);

		List<FavoriteResponseDTO> listAccounts = new ArrayList<>();
		FavoriteResponseDTO response = new FavoriteResponseDTO();
		response.setAccountId(1);
		response.setAccountName("Professor");
		response.setBankName("Nairobi");
		response.setIban("ES211234567878904567");
		listAccounts.add(response);

		Page<Favorite> page = new PageImpl<Favorite>(list);

		Pageable paging = PageRequest.of(0, 5);

		Mockito.when(customerRepository.findByCustomerId(Mockito.anyInt())).thenReturn(customer);
		Mockito.when(favoriteRepository.findAll(paging)).thenReturn(page);
		List<FavoriteResponseDTO> responselist = favoriteServiceImpl.getAllFavoriteAccounts(1, 0, 5);

		assertEquals(1, responselist.size());
		assertEquals("Professor", responselist.get(0).getAccountName());
		assertEquals("ES21123478974563", responselist.get(0).getIban());

	}
}