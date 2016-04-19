package com.simpleinvoice.forms;

import java.io.Serializable;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import com.simpleinvoice.entities.User;
import com.simpleinvoice.entities.UserAuthority;
import com.simpleinvoice.valueobjects.ControlEmail;
import com.simpleinvoice.valueobjects.ControlPassword;

public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Valid
	private ControlEmail email;
	@NotBlank @SafeHtml
	private String username;
	@NotBlank @SafeHtml
	private String firstname;
	@NotBlank @SafeHtml
	private String secondname;
	@Valid
	private ControlPassword password;
	
	public UserForm() {}

	public ControlEmail getEmail() {
		return email;
	}
	
	public void setEmail(ControlEmail email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}
	
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public ControlPassword getPassword() {
		return password;
	}

	public void setPassword(ControlPassword password) {
		this.password = password;
	}
	
	public void clearPassword() {
		password.clear();
	}
	
	public User createUser(UserAuthority authority) {
		User user = new User(email.getValue(), username, firstname, secondname);
		user.setPassword(password.getValue());
		user.addAuthority(authority);
		return user;
	}
}
