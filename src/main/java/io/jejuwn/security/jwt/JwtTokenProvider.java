package io.jejuwn.security.jwt;



import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtTokenProvider {
	
	//Token configuration
	// @Value("${jwt_secret}")
	private static final String JWT_SECRET = "secretKeyDonutSteal";
	private static final int JWT_EXPIRATION_MS = 604800000;
	
	public String generateToken(String nick) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject("User Info")
                .withClaim("nick", nick)
                //.withClaim("role", role)
                .withIssuedAt(new Date())
                .withIssuer("jejuwn_auth")
                //.withExpiresAt(exp)
                .sign(Algorithm.HMAC256(JWT_SECRET));
    }

    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWT_SECRET))
                .withSubject("User Info")
                .withIssuer("jejuwn_auth")
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
	
	public static String getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(JWT_SECRET)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
	public static boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
	}

}
