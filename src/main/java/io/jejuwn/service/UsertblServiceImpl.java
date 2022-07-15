package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.UsertblMapper;
import io.jejuwn.model.Role;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.RoleRepository;
import io.jejuwn.repository.UserRepository;
import io.jejuwn.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsertblServiceImpl implements UsertblService, UserDetailsService {
	
	private final JwtTokenProvider tokenUtils;
	
	@Autowired
	private UsertblMapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<Usertbl> listUser() {
		return mapper.selectByExample(null);
	}
	
	@Override
	public void insertUser(Usertbl vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void deleteUser(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	@Override
	public Usertbl userDetail(Long id) {
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
	}
	@Override
	public void updateUser(Usertbl vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	@Override
	public Optional<Usertbl> findByIdPw(Long id) { return userRepository.findById(BigDecimal.valueOf(id)); }
	// i love my repository
	// where is my repository
	/*
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠛⢻⣿⣯⣿⣿⣿⣶⣶⣶⣶⣤⣤⣤⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⢨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠈⠻⣿⡛⠉⠭⠉⠉⢉⣿⣿⣧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠈⠙⠲⣶⠖⠄⠄⢿⣿⠄⠶⣶⣾⣿⣿⣿⣿⣧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠈⠄⠄⠄⠺⢿⡗⠄⣹⣿⣿⠿⣟⣿⡏⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠤⠤⢾⣿⣿⣿⣦⠘⡿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠈⢻⡿⣷⣶⣶⣤⣤⣤⣶⣦⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⣽⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠘⠿⣿⣿⣿⣿⣿⣿⣿⠃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⠉⠛⠋⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 * 
	 */

	@Override
	public Optional<Usertbl> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(BigDecimal.valueOf(id));
	}

	@Override
	public Optional<Usertbl> findByNick(String nick) {
		// TODO Auto-generated method stub
		return userRepository.findByNick(nick);
	}

	@Override
	public Optional<Usertbl> findByIdAndPass(Long id, String pass) {
		// TODO Auto-generated method stub
		return userRepository.findByIdAndPass(BigDecimal.valueOf(id), pass);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void grantRoleToUser(String username, String roleName) {
		log.info("Grant new role {} to {}", roleName, username);
        Usertbl user = userRepository.findByNick(username).get();
        Role role = roleRepository.findByName(roleName).get();

        user.getRoles().add(role);
		
	}

	@Override
	public UserDetails loginCheckUser(String nick) throws UsernameNotFoundException{
		Usertbl user = userRepository.findByNick(nick).get();
		if(user == null) {
			log.error("User not found. NULL");
			throw new UsernameNotFoundException("User not found");
		}else {
			log.info("User found, logging in");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getNick(), user.getPass(), authorities);
	}

	@Override
	public Usertbl saveUser(Usertbl user) {
		// TODO Auto-generated method stub
		log.info("saved user");
		return userRepository.save(user);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usertbl user = userRepository.findByNick(username).get();
		if(user == null) {
			log.error("User {} not found in database", username);
			throw new UsernameNotFoundException("User not found in db");
		}else {
			log.info("User {} selected", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			
		});
		
		return new org.springframework.security.core.userdetails.User(user.getNick(), user.getPass(), authorities);
	}

}
