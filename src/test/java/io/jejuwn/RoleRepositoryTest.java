package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.RoleRepository;
import io.jejuwn.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
// @DataJpaTest
// @AutoConfigureTestDatabase
public class RoleRepositoryTest {
	
	@Autowired
	RoleRepository roleRepository;
	
	//@Test
	void findByNickRep() {
		log.info("-------------------------");
		log.info("-------------------------");
		log.info(roleRepository.findByName("ROLE_USER"));
	}

}