package com.simpleinvoice.services;

import com.simpleinvoice.entities.UserAuthority;

public interface UserAuthorityService {
	UserAuthority findByName(String name);
}
