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
		= "select username, password, enabled from auth-user"
		+ " where username = ?";
	
	private static final String SQL_AUTHORITIES
		= "select auth-user.username, authority.name as authorities from auth-user"
		+ " inner join auth-user_authority on auth-user.id = auth-user_authority.userid"
		+ " inner join auth-authority on auth-authority.id = auth-user_authority.authorityid"
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
		/*http.formLogin().loginPage("/signin").and()
		.authorizeRequests()
			.antMatchers("/").hasAnyAuthority(ADMINISTRATOR, USER);
		http.httpBasic();*/
	}

}
