package com.simpleinvoice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auth-user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private boolean enabled;
	private String firstname;
	private String secondname;
	private String email;
	
	protected User() {}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public String getEmail() {
		return email;
	}
	
	
	
}
