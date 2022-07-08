package io.jejuwn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import io.jejuwn.service.UsertblService;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		// prePostEnabled = true)
public class SecurityConfig {
	
	// for reference, you should be using this from 5.7.0 onwards
	
	@Autowired
	UsertblService userService;
	
	//@Autowired
	//private AuthEntryPointJwt unauthorizedHandler;
	
	//@Bean
	//public AuthTokenFilter authenticationTokenFilter() {
		
	//}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/api/auth/**").permitAll()
		.antMatchers("/api/test/**").permitAll()
		.anyRequest().authenticated();
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	*/
	
	

}
