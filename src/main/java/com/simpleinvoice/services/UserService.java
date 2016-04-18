package com.simpleinvoice.services;

import com.simpleinvoice.entities.User;

public interface UserService {
	User findByUsername(String username);
}
