package com.ing.payeemanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ing.payeemanagement.dto.FavoriteDto;
import com.ing.payeemanagement.dto.FavoriteResponseDTO;
import com.ing.payeemanagement.dto.ResponseDto;
import com.ing.payeemanagement.entity.Customer;
import com.ing.payeemanagement.entity.Favorite;
import com.ing.payeemanagement.exception.MaxFavoriteAccountException;
import com.ing.payeemanagement.exception.RecordNotFoundException;
import com.ing.payeemanagement.repository.CustomerRepository;
import com.ing.payeemanagement.repository.FavoriteRepository;

/**
 * @author Laxman
 *
 */

@Service
public class FavoriteServiceImpl implements FavoriteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteServiceImpl.class);

	@Value("${max.favorite}")
	private int maxFavorite;

	@Value("${expiry.favorite}")
	private long expiryFavorite;

	@Autowired
	private FavoriteRepository favoriteRepository;

	@Autowired
	private MailService mailService;

	@Autowired
	private CustomerRepository customerRepository;

	public List<FavoriteResponseDTO> getAllFavoriteAccounts(int customerId, Integer pageNo, Integer pageSize) {

		Customer customer = customerRepository.findByCustomerId(customerId);

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Favorite> pageResult = favoriteRepository.findAll(paging);
		List<Favorite> pagedResult = pageResult.getContent();

		List<FavoriteResponseDTO> pagedResultdto = new ArrayList<>();
		if (customer != null) {

			pagedResult.forEach(favorite -> {
				if (favorite.getStatus() == 1 && favorite.getCustomerId() == customerId) {
					FavoriteResponseDTO favoriteResponseDTO = new FavoriteResponseDTO();
					favoriteResponseDTO.setAccountId(favorite.getFavoriteId());
					favoriteResponseDTO.setAccountName(favorite.getName());
					favoriteResponseDTO.setBankName(favorite.getBank());
					favoriteResponseDTO.setIban(favorite.getIban());
					pagedResultdto.add(favoriteResponseDTO);
				}
			});
		}

		else {
			throw new RecordNotFoundException("Record Not Found");

		}
		return pagedResultdto;
	}

	public ResponseDto addFavorite(FavoriteDto favoriteDto) {

		LOGGER.info("FavoriteServiceImpl :: addFavorite -- START");

		List<Favorite> favorites = favoriteRepository.findByCustomerId(favoriteDto.getCustomerId());
		ResponseDto responseDto = new ResponseDto();

		LOGGER.info("FavoriteServiceImpl :: addFavorite -- if condition ");
		if (favorites.isEmpty() || favorites.size() < maxFavorite) {

			Customer customer = customerRepository.findByCustomerId(favoriteDto.getCustomerId());
			LOGGER.info("FavoriteServiceImpl :: addFavorite -- in condition");
			Favorite favorite = new Favorite();
			BeanUtils.copyProperties(favoriteDto, favorite);
			favorite.setName(favoriteDto.getAccountName());
			favorite.setBank(favoriteDto.getBankName());
			favorite.setStatus(1);
			favorite.setCreatedDate(LocalDateTime.now());
			LocalDate expiryDate = LocalDate.now().plusYears(expiryFavorite);
			favorite.setExpiryDate(expiryDate);
			favoriteRepository.save(favorite);
			responseDto.setMessage("Favorite Added successfully.");
			responseDto.setStatus("success");
			responseDto.setStatusCode(201);

		} else {

			LOGGER.info("FavoriteServiceImpl :: addFavorite -- throwing maxException");
			throw new MaxFavoriteAccountException("Allowed only " + maxFavorite + " favorite accounts.");
		}

		LOGGER.info("FavoriteServiceImpl :: addFavorite -- END");
		return responseDto;
	}

}
