package org.janine.jian.securityjwtapp.security;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppWebSecurity extends WebSecurityConfigurerAdapter{

	public final static String signkey = "ZmQ0ZGI5NjQ0MDQwY2I4MjMxY2Y3ZmI3MjdhN2ZmMjNhODViOTg1ZGE0NTBjMGM4NDA5NzYxMjdjOWMwYWRmZTBlZjlhNGY3ZTg4Y2U3YTE1ODVkZDU5Y2Y3OGYwZWE1NzUzNWQ2YjFjZDc0NGMxZWU2MmQ3MjY1NzJmNTE0MzI=";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new LoginAuthenticationFilter(authenticationManager()))
			.addFilter(new ActionAuthenticationFilter(authenticationManager()));
	}

	
}
