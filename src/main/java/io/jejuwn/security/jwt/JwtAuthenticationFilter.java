package io.jejuwn.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;

import io.jejuwn.security.service.UserDetailsServiceImpl;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtTokenProvider jwtUtil;
	
@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader = request.getHeader("Authorization");
	    if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){
	        String jwt = authHeader.substring(7);
	        if(jwt == null || jwt.isBlank()){
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
	        }else {
	            try{
	                String nick = jwtUtil.validateTokenAndRetrieveSubject(jwt);
	                UserDetails userDetails = userDetailsService.loadUserByUsername(nick);
	                UsernamePasswordAuthenticationToken authToken =
	                        new UsernamePasswordAuthenticationToken(nick, userDetails.getPassword(), userDetails.getAuthorities());
	                if(SecurityContextHolder.getContext().getAuthentication() == null){
	                    SecurityContextHolder.getContext().setAuthentication(authToken);
	                }
	            }catch(JWTVerificationException exc){
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
	            }
	        }
	    }
		
		filterChain.doFilter(request, response);
			
		}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("BearerToken ")) {
			return bearerToken.substring("BearerToken ".length());
		}
		return null;
	}

}
