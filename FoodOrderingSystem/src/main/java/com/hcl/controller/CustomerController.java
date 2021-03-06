package com.hcl.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.model.Customer;

import com.hcl.services.ICustomerServices;
import com.hcl.token.ITokenGenerator;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
@Validated
public class CustomerController {
	@Autowired
	private ICustomerServices cs;
//	@Autowired
//	private IAddressImpl addressServices;

	@Autowired
	ITokenGenerator tg;

	//To get customer details
	@GetMapping("/getCustomerDetails/{email}")
	public ResponseEntity<Customer> getCustomerOnEmail(@PathVariable String email) {
		return new ResponseEntity<Customer>(cs.getByEmailId(email), HttpStatus.OK);
	}

	//To add new customer
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		System.out.println(customer);
		return new ResponseEntity<Customer>(cs.addCustomer(customer), HttpStatus.OK);
	}
	
	//To get credentials of user
	@GetMapping("/getCredentails/{email}/{password}")
	public ResponseEntity<?> getCredentials(@PathVariable String email, @PathVariable String password) {
		Customer c = cs.getEmailAndPassword(email, password);
		System.out.println(c);
		if (c != null) {
			Map<String, String> map = tg.generateToken(c);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Email and Password is incorrect", HttpStatus.NOT_FOUND);
	}


}
