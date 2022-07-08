package io.jejuwn.security.jwt;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication extends UsernamePasswordAuthenticationToken{

	public UserAuthentication(String principal, String credentials) {
		super(principal, credentials);
		// TODO Auto-generated constructor stub
	}
	
	public UserAuthentication(String principal, String credentials , List<GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

}
