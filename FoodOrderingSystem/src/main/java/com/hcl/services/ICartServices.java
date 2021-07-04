package com.hcl.services;

import java.util.List;

import com.hcl.model.Cart;

public interface ICartServices {
	public boolean deleteCartItems();

	Cart addCart(Cart cart);

	List<Cart> getItems();

	void deleteItem(int foodId);
}
