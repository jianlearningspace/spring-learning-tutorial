package org.janine.jian.securityjwtapp.security;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
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
                .claim("AUTH", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))//有效期两小时
                .signWith(SignatureAlgorithm.HS256, bytesEncoded)
                .compact();

        response.addHeader("token", "Bearer " + token);
        try {
			response.getWriter().write("Bearer " + token);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	

}
