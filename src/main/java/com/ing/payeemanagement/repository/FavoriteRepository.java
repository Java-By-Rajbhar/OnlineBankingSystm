package com.ing.payeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.payeemanagement.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

}
