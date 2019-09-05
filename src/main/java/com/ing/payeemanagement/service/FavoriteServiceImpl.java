package com.ing.payeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.entity.Customer;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.exception.RecordNotFoundException;
import com.ing.payeemanagement.repository.CustomerRepository;
import com.ing.payeemanagement.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired

	FavoriteRepository repository;

	@Autowired

	CustomerRepository customerRepository;

	public List<FavoriteResponseDTO> getAllFavoriteAccounts(int customerId, Integer pageNo, Integer pageSize) {

		Customer customer = customerRepository.findByCustomerId(customerId);

		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Favorite> pagedResult = repository.findAll(paging);
		List<FavoriteResponseDTO> pagedResultdto = new ArrayList<>();

		if (customer.getCustomerId() == customerId) {

			if (pagedResult.hasContent()) {
				for (Favorite favorite : pagedResult) {
					if (favorite.getStatus() == 1) {
						FavoriteResponseDTO favoriteResponseDTO = new FavoriteResponseDTO();
						favoriteResponseDTO.setAccountId(favorite.getFavoriteId());
						favoriteResponseDTO.setAccountName(favorite.getName());
						favoriteResponseDTO.setBankName(favorite.getBank());
						favoriteResponseDTO.setIban(favorite.getIban());
						pagedResultdto.add(favoriteResponseDTO);
					}

				}
			}
		}
		else{
			throw new RecordNotFoundException("Record Not Found");
		}

		return pagedResultdto;
	}

}
