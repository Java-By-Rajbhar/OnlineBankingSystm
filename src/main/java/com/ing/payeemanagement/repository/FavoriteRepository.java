package com.ing.payeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.payeemanagement.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	List<Favorite> findByCustomerId(int customerId);
}
