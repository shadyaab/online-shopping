package net.kzm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shoppingbackend.dao.UserDAO;
import net.kzm.shoppingbackend.dto.Address;
import net.kzm.shoppingbackend.dto.Cart;
import net.kzm.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");

	}

	// @Test
	// public void testAdd() {
	// user = new User();
	// user.setFirstName("Shadyaab");
	// user.setLastname("Akhtar");
	// user.setContactNumber("12763722");
	// user.setEmail("shadyaab@gmail.com");
	// user.setPassword("123456");
	// user.setRole("USER");
	//
	// assertEquals("Failed to add User!!", true, userDAO.addUser(user));
	//
	// address= new Address();
	// address.setAddressLineOne("121 ashda Nagar");
	// address.setAddressLineTwo("Kadru");
	// address.setCity("Ranchi");
	// address.setState("Jharkhand");
	// address.setCountry("India");
	// address.setPostalCode("237233");
	// address.setBilling(true);
	//
	// //Link the address with user
	// address.setUserId(user.getId());
	//
	// assertEquals("Failed to add Address", true, userDAO.addAddress(address));
	//
	// if(user.getRole().equals("USER")) {
	// cart = new Cart();
	// cart.setUser(user);
	//
	// assertEquals("Failed to add cart",true, userDAO.addCart(cart));
	//
	// //Adding shipping address
	// address= new Address();
	// address.setAddressLineOne("1232 ashda Nagar");
	// address.setAddressLineTwo("hinpidi");
	// address.setCity("Ranchi");
	// address.setState("Jharkhand");
	// address.setCountry("India");
	// address.setPostalCode("237221");
	// address.setShipping(true);
	//
	// address.setUserId(user.getId());
	//
	// assertEquals("Failed to add shipping address", true,
	// userDAO.addAddress(address));
	//
	// }
	//
	// }

	// @Test
	// public void testAdd() {
	// user = new User();
	// user.setFirstName("Shadyaab");
	// user.setLastname("Akhtar");
	// user.setContactNumber("12763722");
	// user.setEmail("shadyaab@gmail.com");
	// user.setPassword("123456");
	// user.setRole("USER");
	//
	// if(user.getRole().equals("USER")) {
	// cart = new Cart();
	// cart.setUser(user);
	//
	// user.setCart(cart);
	//
	// assertEquals("Failed to add user",true, userDAO.addUser(user));
	// }
	// }

	// @Test
	// public void testUpdateCart() {
	//
	// //fetch the user
	// user = userDAO.getByEmail("shadyaab@gmail.com");
	//
	// //get the cart of the user
	// cart = user.getCart();
	//
	// cart.setGrandTotal(555);
	// cart.setCartLines(2);
	// assertEquals("Faied to update the cart", true, userDAO.updateCart(cart));
	// }

	// @Test
	// public void testAddAddress() {
	//
	// user = new User();
	// user.setFirstName("Shadyaab");
	// user.setLastname("Akhtar");
	// user.setContactNumber("12763722");
	// user.setEmail("shadyaab@gmail.com");
	// user.setPassword("123456");
	// user.setRole("USER");
	//
	// assertEquals("Failed to add User!!", true, userDAO.addUser(user));
	//
	// /* Billing address*/
	// address= new Address();
	// address.setAddressLineOne("121 ashda Nagar");
	// address.setAddressLineTwo("Kadru");
	// address.setCity("Ranchi");
	// address.setState("Jharkhand");
	// address.setCountry("India");
	// address.setPostalCode("237233");
	// address.setBilling(true);
	//
	// //Attach the user to the address
	// address.setUser(user);
	//
	// assertEquals("Failed to add Address", true, userDAO.addAddress(address));
	//
	// /* Shipping Address */
	// address= new Address();
	// address.setAddressLineOne("1232 ashda Nagar");
	// address.setAddressLineTwo("hinpidi");
	// address.setCity("Ranchi");
	// address.setState("Jharkhand");
	// address.setCountry("India");
	// address.setPostalCode("237221");
	// address.setShipping(true);
	//
	// //Attach the user to the address
	// address.setUser(user);
	//
	// assertEquals("Failed to add Address", true, userDAO.addAddress(address));
	//
	// }

	//@Test
	// public void testAddAddress() {
	//
	// user = userDAO.getByEmail("shadyaab@gmail.com");
	//
	// address= new Address();
	// address.setAddressLineOne("1232 ashda Nagar");
	// address.setAddressLineTwo("Electronic city");
	// address.setCity("Bangalore");
	// address.setState("Karnataka");
	// address.setCountry("India");
	// address.setPostalCode("560100");
	// address.setShipping(true);
	//
	// //Attach the user to the address
	// address.setUser(user);
	//
	// assertEquals("Failed to add Address", true, userDAO.addAddress(address));
	// }

	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("shadyaab@gmail.com");
		
		assertEquals("Failed to fetch address", 2, userDAO.listShippingAddress(user).size());
	
		assertEquals("Failed to fetch Billing address", "Ranchi", userDAO.getBillingAddress(user).getCity());
	}

}





















