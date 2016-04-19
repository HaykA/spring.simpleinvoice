package com.simpleinvoice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name="auth_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank @SafeHtml
	private String username;
	@NotBlank //TODO @Password
	private String password;
	private boolean enabled;
	@NotBlank @Email
	private String email;
	@NotBlank @SafeHtml
	private String firstname;
	@NotBlank @SafeHtml
	private String secondname;
	
	
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
	
	public String getName() {
		return firstname + " " + secondname;
	}
	
}
