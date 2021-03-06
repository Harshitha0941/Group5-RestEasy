package com.hcl.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.hcl.model.Customer;

@Repository
public interface ICustomerDAO extends JpaRepository<Customer, Integer>{
	// @Query(value="SELECT * FROM customer where email=?1 and password=?2",nativeQuery=true)
	 public Customer findByEmailAndPassword(String email,String password);
	 public Customer findByEmail(String email);
}
