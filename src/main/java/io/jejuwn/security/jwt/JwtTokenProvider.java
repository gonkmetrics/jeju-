package io.jejuwn.security.jwt;



import java.security.Key;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.jejuwn.model.Role;
import io.jejuwn.model.Usertbl;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtTokenProvider {
	
	//Token configuration
	// @Value("${jwt_secret}")
	//private static final String JWT_SECRET = "secretKeyDonutSteal";
	private static final String JWT_REFRESH = "refreshKey";
	private static final String DATA_KEY = "userId";
	private static final int JWT_EXPIRATION_MS = 604800000;
	Algorithm algorithm = Algorithm.HMAC256("secretKey".getBytes());
	
	public String generateToken(User user) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                //.withIssuer(request.getRequestURI().toString())
                .withIssuer("jejuwn")
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

    }
	
	public String generateRefreshToken(User user) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 300 * 60 * 1000))
                //.withIssuer(request.getRequestURI().toString())
                .withIssuer("jejuwn")
                .sign(algorithm);
    }
	
	public Date getRefreshTokenExpiry(String token) throws JWTVerificationException {
		JWTVerifier verifier = JWT.require(algorithm)
				.build();
		DecodedJWT jwt = verifier.verify(token);
		Date expiry = jwt.getExpiresAt();
		return expiry;
	}
	
	public String getTokenPrincipal(String token) throws JWTVerificationException{
		JWTVerifier verifier = JWT.require(algorithm)
				.build();
		DecodedJWT jwt = verifier.verify(token);
		String principal = jwt.getSubject();
		return principal;
	}
	


    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("jejuwn")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("nick").asString();
    }
	
	/*
	public static String generateToken(Authentication authentication) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);
		
		return Jwts.builder()
				.setSubject((String) authentication.getPrincipal())
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
	}*/
	
	//include method that uses authentication object

}
