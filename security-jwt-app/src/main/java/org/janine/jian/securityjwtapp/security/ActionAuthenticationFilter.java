package org.janine.jian.securityjwtapp.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ActionAuthenticationFilter extends BasicAuthenticationFilter{

	public ActionAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("token");

        //判断是否有token
        if (token == null || !token.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);


    }

	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
    	byte[] bytesEncoded = Base64.getEncoder().encode(AppWebSecurity.signkey.getBytes());

        Claims claims = Jwts.parser().setSigningKey(bytesEncoded)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        
        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("AUTH").toString().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        String username = claims.getSubject();
        Date expiration = claims.getExpiration();

        if (System.currentTimeMillis() > expiration.getTime()) 
            throw new UsernameNotFoundException("该账号已过期,请重新登陆");

        if (username != null) return new UsernamePasswordAuthenticationToken(username, claims.get("password"), authorities);
        
        return null;
    }

}
