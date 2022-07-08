package io.jejuwn;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import io.jejuwn.security.jwt.JwtTokenProvider;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class JwtTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	JwtTokenProvider token;
	
	@Test
	public void postTestToken() {
		var tokenString = token.generateToken("waggy");
		Map<String, String> bodyMap = new HashMap<String, String>();
		bodyMap.put("password", "abc");
		bodyMap.put("nick", "waggy");
		
		webTestClient
		.post().uri("/auth/login")
		.contentType(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromValue(bodyMap))
		.headers(http -> http.setBearerAuth(tokenString))
		.exchange() //check head
		.expectStatus().isOk();
		
		log.info(tokenString);
		
		String validation = token.validateTokenAndRetrieveSubject(tokenString);
		log.info(validation);
	}
	
	/*
	public JwtDecoder jwtDecoder() {
		return new JwtDecoder() {
		}
	}
	*/
}
