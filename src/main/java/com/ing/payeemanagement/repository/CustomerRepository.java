package com.ing.payeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.payeemanagement.entity.Customer;
/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByCustomerId(int customerId);
}
