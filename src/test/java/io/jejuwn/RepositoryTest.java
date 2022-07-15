package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.Role;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.RoleRepository;
import io.jejuwn.repository.UserRepository;
import io.jejuwn.service.UsertblService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
// @DataJpaTest
// @AutoConfigureTestDatabase
public class RepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UsertblService userService;
	
	@Autowired
	RoleRepository roleRepository;
	
	//@Test
	void buildRep() {
		String nick = "alice123";
		final Usertbl user = Usertbl.builder().nick(nick).build();
		final Usertbl savedUser = userRepository.save(user);
		assertEquals(nick, savedUser.getNick());
	}
	
	void SaveRep() {
		//don't run this
	}
	
	//@Test
	void findByInRep() {
		log.info("-------------------------");
		log.info("-------------------------");
		log.info(userRepository.findById(BigDecimal.valueOf(1))); 
	}
	
	//@Test
	void findByNickRep() {
		log.info("-------------------------");
		log.info("-------------------------");
		log.info(userRepository.findByNick("bob123"));
	}
	
	//@Test
	void roleSelect() {
		Role role = roleRepository.findByName("ROLE_USER").get();
		log.warn(role);
	}
	
	//@Test
	void roleAdd() {
		Role role = roleRepository.findByName("ROLE_USER").get();
		log.warn(role);
		//Usertbl user = Usertbl.builder().nick("test3").name("dave").pass("abc").gender(BigDecimal.valueOf(1)).age(BigDecimal.valueOf(20)).email("testemail3").role(BigDecimal.valueOf(1)).build();
		//log.info(user.getRoles());
		Role roleA = roleRepository.findByName("ROLE_USER").get();
		log.info(roleA);
		//user.getRoles().add(roleA);
		Collection roleB = new ArrayList<>();
		roleB.add(roleA);
		log.warn(roleB);
		//user.setRoles(roleB);
		//log.warn(user);
	}
	
	@Test
	void roleAddSingular() {
		Role role = roleRepository.findByName("ROLE_USER").get();
		log.warn(role);
		Usertbl user = Usertbl.builder().nick("test3").name("dave").pass("abc").gender(BigDecimal.valueOf(1)).age(BigDecimal.valueOf(20)).email("testemail3").build();
		//user = Usertbl.builder().role(role).build();
		//.role(roleRepository.findByName("ROLE_USER").get())
		//log.info(user.getRoles());
		//log.info(user.getRoles());
		//log.info(roleA);
		log.warn(user.getRoles().getClass());
		try {
			user.getRoles().add(role);
		} catch (Exception e) {
			// TODO: handle exception
		log.warn(e);
		e.printStackTrace();
		}
		
		//Collection roleB = new ArrayList<>();
		//roleB.add(role);
		//log.warn(roleB);
		//user.setRoles(roleB);
		log.warn(user);
		userService.saveUser(user);
	}
	
	//@Test
	void addUser() {
		//Collection roleA = new HashSet<String>();
		//roleA.add("ROLE_ADMIN");
		log.warn("STEP1");
		//Usertbl userInsert = Usertbl.builder().nick("test3").name("dave").pass("abc").gender(BigDecimal.valueOf(1)).age(BigDecimal.valueOf(20)).email("testemail3").role(BigDecimal.valueOf(1)).build();
		log.warn("STEP2");
		//userInsert.getRoles().add(roleRepository.findByName("ROLE_USER").get());
		log.warn("STEP3");
		//log.info(userInsert);
		//userService.saveUser(userInsert);
	}

}
