package com.simpleinvoice.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpleinvoice.dao.UserAuthorityDAO;
import com.simpleinvoice.entities.UserAuthority;

@ReadOnlyTransactionalService
public class UserAuthorityServiceImpl implements UserAuthorityService {

	private final UserAuthorityDAO userAuthorityDAO;
	
	@Autowired
	UserAuthorityServiceImpl(UserAuthorityDAO userAuthorityDAO) {
		this.userAuthorityDAO = userAuthorityDAO;
	}
	
	@Override
	public UserAuthority findByName(String name) {
		return userAuthorityDAO.findByName(name);
	}

}
