package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;
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
	
	@Test
	void buildRep() {
		String nick = "alice123";
		final Usertbl user = Usertbl.builder().nick(nick).build();
		final Usertbl savedUser = userRepository.save(user);
		assertEquals(nick, savedUser.getNick());
	}
	
	void SaveRep() {
		//don't goddamn run this
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

}
