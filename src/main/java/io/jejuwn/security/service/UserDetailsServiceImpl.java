package io.jejuwn.security.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
        Optional<Usertbl> userRes = userRepo.findByNick(nick);
        if(userRes.isEmpty())
            throw new UsernameNotFoundException("Could not find User with name = " + nick);
        Usertbl user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                nick,
                user.getPass(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
	

}
