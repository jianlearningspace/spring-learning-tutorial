package org.janine.jian.securityjwtapp.security;

import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 自定义UsernamePasswordAuthenticationFilter
 * @author jian
 *
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	

	public LoginAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username == null) username = "";
		if (password == null) password = "";

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	@SuppressWarnings("deprecation")
	@Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) {
		String authorities = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
		
		byte[] bytesEncoded = Base64.getEncoder().encode(AppWebSecurity.signkey.getBytes());
		
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("username", authResult.getPrincipal())
                .claim("password", authResult.getCredentials())
                .claim("AUTH", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))//有效期两小时
                .signWith(SignatureAlgorithm.HS256, bytesEncoded)
                .compact();

        response.addHeader("token", "Bearer " + token);
    }
	
	

}
