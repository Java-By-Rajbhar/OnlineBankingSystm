package com.ing.payeemanagement.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class Customer {
	
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String email;

}
