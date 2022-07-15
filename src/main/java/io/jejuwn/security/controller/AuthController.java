package io.jejuwn.security.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.jejuwn.model.Role;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.RoleRepository;
import io.jejuwn.repository.UserRepository;
import io.jejuwn.security.jwt.JwtTokenProvider;
import io.jejuwn.security.model.LoginCredentials;
import io.jejuwn.service.UsertblService;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@RestController
//@RequestMapping("/auth")
@Log4j2
public class AuthController {

    //@Autowired private UserRepository userRepo;
    @Autowired private JwtTokenProvider jwtTokens;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UsertblService userService;
    @Autowired private RoleRepository roleRepository;
    @Autowired private RedisTemplate<String, Object> redisTemplate;
    
    @PostMapping("/user/save")
    public ResponseEntity<Usertbl> saveUser(@RequestBody SignUpForm signUpForm) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/user/save").toUriString());

        Usertbl user = signUpForm.toEntity();
        log.info(user);
        user.setPass(passwordEncoder.encode(user.getPass()));
        user.getRoles().add(roleRepository.findByName("ROLE_USER").get());
        log.info(user);

        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/role/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    
    @PostMapping("/role/grant-to-user")
    public ResponseEntity<?> grantRole(@RequestBody SignUpForm form) {
        userService.grantRoleToUser(form.getNick(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logoutHandler(@RequestHeader("Authorization") String authorizationHeader) {
    	try {
    		String subject = jwtTokens.getTokenPrincipal(authorizationHeader);
    		log.info(subject);
        	redisTemplate.opsForValue()
            .set(subject, "", 1, TimeUnit.MILLISECONDS);;
        	return ResponseEntity.ok("Logged out");
    	}catch (Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	} 	
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginCredentials body) {
        try {
        	log.info(body);
            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(body.getId(), body.getPassword());
            log.info(authInputToken);
            Authentication authentication = authManager.authenticate(authInputToken);
            User user = (User) authentication.getPrincipal();
            log.info(user);
            
            String accessToken = jwtTokens.generateToken(user);
            String refreshToken = jwtTokens.generateRefreshToken(user);
            Date refreshTokenExpiryDate = jwtTokens.getRefreshTokenExpiry(refreshToken);
            Date current = new Date(System.currentTimeMillis());
            Long refreshTokenExpiry = refreshTokenExpiryDate.getTime() - current.getTime();
            
            redisTemplate.opsForValue()
            .set(authentication.getName(), refreshToken, refreshTokenExpiry, TimeUnit.MILLISECONDS);

            return ResponseEntity.ok()
                .header(
                    HttpHeaders.AUTHORIZATION,
                    accessToken
                )
                .body(refreshToken);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        	}
        }
    
    @PostMapping("/token/refresh")
    public ResponseEntity<String> refreshToken(@RequestHeader("AUTHORIZATION") String authorizationHeader) throws IOException {

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try{
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secretKey".getBytes());

                JWTVerifier verifier = JWT.require(algorithm).build();

                DecodedJWT decodedJWT = verifier.verify(refreshToken);

                String username = decodedJWT.getSubject();
                //Usertbl user = userService.findByNick(username).get();
                log.info("tokenRefresh");
                log.info(userService.findByNick(username).get());
                
                
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

                String accessToken = jwtTokens.generateToken(user);


                //Map<String, String> tokens = new HashMap<>();
                //tokens.put("access_token", accessToken);
                //tokens.put("refresh_token", refreshToken);
                
                return ResponseEntity.ok()
                        .header(
                            HttpHeaders.AUTHORIZATION,
                            accessToken
                        ).body("token refreshed");

                //response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                //new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }catch (Exception e) {
            	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                //response.setHeader("error", e.getMessage());
                //response.setStatus(401);

                //Map<String, String> error = new HashMap<>();
                //error.put("error_message", e.getMessage());
                //response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                //new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
    
    @GetMapping("/token/revoke")
    public void revokeToken() {
    	
    }

}

@Data
@Builder
class SignUpForm {
    private String nick;
    private String name;
    private String pass;
    private BigDecimal gender;
    private String email;
    //private BigDecimal role;
    private String roleName;

    public Usertbl toEntity() {
        return Usertbl
                .builder().nick(this.nick).name(this.name).pass(this.pass).gender(this.gender).email(this.email)
                //.roles(new ArrayList<>())
                .build();
    }
}

