package com.hcl.services;

import java.util.List;

import com.hcl.model.Menu;

public interface IRestuarantServices {
	List<Menu> getResturant(String name);
}
