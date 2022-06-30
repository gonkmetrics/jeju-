package io.jejuwn;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.Usertbl;
import io.jejuwn.service.UserService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	//@Test
	public void testGetList() {
		log.info(service.listUser());
	}
	
	@Test
	public void testInsert() {
		Usertbl vo = new Usertbl();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setName("바바밥");
		vo.setNick("고고고");
		vo.setPass("1111");
		vo.setGender(BigDecimal.valueOf(1));
		vo.setAge(BigDecimal.valueOf(20));
		vo.setEmail("2222222@222.com");
		vo.setRole(BigDecimal.valueOf(1));
		
		service.insertUser(vo);
		log.info(service.listUser());
	}

}
