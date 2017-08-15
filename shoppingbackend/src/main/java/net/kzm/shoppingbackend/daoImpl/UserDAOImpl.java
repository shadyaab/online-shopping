package net.kzm.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shoppingbackend.dao.UserDAO;
import net.kzm.shoppingbackend.dto.Address;
import net.kzm.shoppingbackend.dto.Cart;
import net.kzm.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory SessionFactory;
	

	@Override
	public boolean addUser(User user) {
		try {
			SessionFactory.getCurrentSession().persist(user);
			return true;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			SessionFactory.getCurrentSession().persist(address);
			return true;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateCart(Cart cart) {
		try {
			SessionFactory.getCurrentSession().update(cart);
			return true;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		try {
			return SessionFactory.getCurrentSession()
						.createQuery("FROM User WHERE email = :email", User.class)
							.setParameter("email", email)
								.getSingleResult();
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		try {
			return SessionFactory.getCurrentSession()
						.createQuery(selectQuery, Address.class)
							.setParameter("user", user)
							.setParameter("billing", true)
								.getSingleResult();
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			return SessionFactory.getCurrentSession()
						.createQuery(selectQuery, Address.class)
							.setParameter("user", user)
							.setParameter("shipping", true)
								.getResultList();
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}














