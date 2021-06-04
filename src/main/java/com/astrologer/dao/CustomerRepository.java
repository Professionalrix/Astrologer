package com.astrologer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astrologer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	/*
	 * @Query("from Customer as c where c.user.id =:userId") public List<Customer>
	 * findByCustomerByUser(@Param("userId") int userId);
	 */
	/*
	 * @Query("from Customer as c where c.user.id =userId") public List<Customer>
	 * findByCustomerByUser(@Param("userId") int userId);
	 */

}
