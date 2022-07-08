package io.jejuwn.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
	
		log.error("Unauthorized error. Message -{}", authException.getMessage());
		
		String unAuthorizationCode = (String) request.getAttribute("unauthorization");
		request.setAttribute("response.failure.code", unAuthorizationCode);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, unAuthorizationCode);
		
	}
	*/

}
