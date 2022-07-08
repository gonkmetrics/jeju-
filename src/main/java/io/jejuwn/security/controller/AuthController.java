package io.jejuwn.security.controller;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;
import io.jejuwn.security.jwt.JwtTokenProvider;
import io.jejuwn.security.jwt.Token;
import io.jejuwn.security.jwt.Token.Response;
import io.jejuwn.security.jwt.UserAuthentication;
import io.jejuwn.security.model.LoginCredentials;
import io.jejuwn.service.UsertblService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private UserRepository userRepo;
    @Autowired private JwtTokenProvider jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody Usertbl user){
        String encodedPass = passwordEncoder.encode(user.getPass());
        user.setPass(encodedPass);
        user = userRepo.save(user);
        String token = jwtUtil.generateToken(user.getNick());
        return Collections.singletonMap("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getNick(), body.getPassword());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getNick());

            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }


}