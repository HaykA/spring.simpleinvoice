package com.simpleinvoice.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CreateSecurityFilter extends WebSecurityConfigurerAdapter {
	
	@SuppressWarnings("unused")
	private static final String ADMINISTRATOR = "administrator";
	
	@SuppressWarnings("unused")
	private static final String USER = "user";
	
	private static final String SQL_USERS
		= "select username, password, enabled from simpleinvoice.auth_user"
		+ " where username = ?";
	
	private static final String SQL_AUTHORITIES
		= "select auth_user.username, auth_authority.name as authorities from auth_user"
		+ " inner join auth_user_authority on auth_user.id = auth_user_authority.userid"
		+ " inner join auth_authority on auth_authority.id = auth_user_authority.authorityid"
		+ " where username = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(SQL_USERS)
			.authoritiesByUsernameQuery(SQL_AUTHORITIES)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
			.antMatchers("/browser/**")
			.antMatchers("/images/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/signin");
		http.httpBasic();
	}

}
