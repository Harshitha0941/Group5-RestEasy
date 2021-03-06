package com.hcl.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.OrderDetails;
import com.hcl.repository.IOrderDAO;

@Service
public class OrderServicesImpl implements IOrderServices {

	@Autowired
	private IOrderDAO orderDao;

	@Override
	@Transactional
	public boolean addOrderDetails(OrderDetails order) {
		OrderDetails o = orderDao.save(order);

		return true;
	}

}
