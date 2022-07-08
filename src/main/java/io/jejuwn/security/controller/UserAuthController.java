package io.jejuwn.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;

@RestController
@RequestMapping("/auth/user")
public class UserAuthController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/info")
    public Usertbl getUserDetails(){
        String nick = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepo.findByNick(nick).get();
    }


}