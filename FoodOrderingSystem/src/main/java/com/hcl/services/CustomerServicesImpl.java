package com.hcl.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Customer;
import com.hcl.repository.ICustomerDAO;
@Service
public class CustomerServicesImpl implements ICustomerServices {
	@Autowired
	private ICustomerDAO customerDao;

	@Override
	public Customer addCustomer(Customer customer) {
		
	
		return customerDao.saveAndFlush(customer);
	}

	@Override
	public Customer getEmailAndPassword(String email, String password) {
		return customerDao.findByEmailAndPassword(email, password);
	}

	@Override
	public Customer getByEmailId(String email) {
		return customerDao.findByEmail(email);
	}

	@Override
    public Customer getById(int customerId) {
        // TODO Auto-generated method stub
        return customerDao.findById(customerId).get();
    }  

}
