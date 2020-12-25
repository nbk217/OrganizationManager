package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
				.withUser("spring").password("{noop}boot")
				.roles("USER", "ADMIN");
		auth.inMemoryAuthentication()
				.withUser("adi").password("{noop}adi")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//TODO remove disable
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/", "/*abcd*/**").access("hasRole('USER')").and()
				.formLogin();
	}

}
