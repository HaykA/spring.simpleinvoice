package com.simpleinvoice.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpleinvoice.dao.UserDAO;
import com.simpleinvoice.entities.User;

@ReadOnlyTransactionalService
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

}
