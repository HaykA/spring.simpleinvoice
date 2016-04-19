package com.simpleinvoice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleinvoice.entities.UserAuthority;

public interface UserAuthorityDAO extends JpaRepository<UserAuthority, Long> {
	UserAuthority findByName(String name);
}
