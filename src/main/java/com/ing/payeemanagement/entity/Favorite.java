package com.ing.payeemanagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class Favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favoriteId;
	private int customerId;
	private String name;
	private String iban;
	private int status;
	private LocalDate createdDate;
	private LocalDate expiryDate;
	private String bank;
	
}



