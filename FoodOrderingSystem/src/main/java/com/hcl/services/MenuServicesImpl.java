package com.hcl.services;

import com.hcl.exception.UserDefinedException;
import com.hcl.model.Cart;
import com.hcl.model.Menu;
import com.hcl.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServicesImpl implements IMenuServices {
	@Autowired
	private IMenuDAO menuDao;
	@Autowired
	private ICartDAO cartDao;

//@Autowired
//private IRestuarantServices restuarantServices;
	@Override
	public List<Menu> getdetailsByRestuarant(int rid) {
		return menuDao.findByRestuarant(rid);
	}

	@Override
	public List<Menu> getFoodByName(String foodName) throws UserDefinedException {

		if (!menuDao.findByFoodName(foodName).isEmpty()) {
			return menuDao.findByFoodName(foodName);
		} else
			throw new UserDefinedException("FoodItem Not Present");
	}

	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.saveAndFlush(cart);
	}
}
