package net.kzm.shoppingbackend.dao;

import java.util.List;

import net.kzm.shoppingbackend.dto.Address;
import net.kzm.shoppingbackend.dto.Cart;
import net.kzm.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	
	boolean updateCart(Cart cart);

}
