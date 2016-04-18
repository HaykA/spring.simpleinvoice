package com.simpleinvoice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleinvoice.entities.User;

public interface UserDAO extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
