package io.jejuwn.security.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.model.Usertbl;
import io.jejuwn.security.jwt.JwtTokenProvider;
import io.jejuwn.security.jwt.Token;
import io.jejuwn.security.jwt.Token.Response;
import io.jejuwn.security.jwt.UserAuthentication;
import io.jejuwn.service.UsertblService;

@RestController
// @RequestMapping(path = "auth")
@RequestMapping("/auth")
public class AuthController_NOc {
	/*
	@Autowired
	private PasswordEncoder passswordEncoder;
	
	//private final AuthenticationManager authenticationManager;
	//private final JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UsertblService userService;
	
	// public AuthController() {
		
	// }
	
	@RequestMapping(
			value = "/login",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			//"login"
			
			)
	public ResponseEntity<?> login(final HttpServletRequest req, final HttpServletResponse res, @Valid @RequestBody Token.Request request) throws Exception {
		Optional<Usertbl> userOptional = userService.findByIdPw(Long.parseLong(request.getId()));
		Usertbl user = userOptional.get();
		if(!request.getSecret().equals(user.getPass())) {
			throw new IllegalArgumentException("Password is incorrect.");
		}
		
		Authentication authentication = new UserAuthentication(request.getId(), null, null);
		String token = JwtTokenProvider.generateToken(authentication);
		Response response = Response.builder().token(token).build();
		ResponseEntity<?> entity = response.toString();
		
		return entity;
	}*/
	
}
