package com.simpleinvoice.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	@ManyToMany
	@JoinTable(
		name = "auth_user_authority",
		joinColumns = @JoinColumn(name = "userid"),
		inverseJoinColumns = @JoinColumn(name = "authorityid"))
	private Set<UserAuthority> authorities = new LinkedHashSet<>();
	
	protected User() {}
	
	public User(String email, String username, String firstname, String secondname) {
		this.email = email;
		this.username = username;
		this.firstname = firstname;
		this.secondname = secondname;
		enabled = true;
	}
	
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
	
	public void setPassword(String password) {
		this.password = (new BCryptPasswordEncoder()).encode(password);
	}
	
	public Set<UserAuthority> getAuthorities() {
		return Collections.unmodifiableSet(authorities);
	}
	
	public void addAuthority(UserAuthority authority) {
		authorities.add(authority);
	}
}
