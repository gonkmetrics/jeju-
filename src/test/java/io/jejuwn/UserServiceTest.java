package io.jejuwn;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.Usertbl;
import io.jejuwn.service.UsertblService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserServiceTest {
	
	@Autowired
	private UsertblService service;
	
	@Autowired
	private UserDetailsService uService;
	
	//@Test
	public void testGetList() {
		log.info(service.listUser());
	}
	
	//@Test
	public void testInsert() {
		Usertbl vo = new Usertbl();
		
		//vo.setId(BigDecimal.valueOf(2));
		vo.setName("eewqq");
		vo.setNick("waggy");
		vo.setPass("abc");
		vo.setGender(BigDecimal.valueOf(1));
		vo.setAge(BigDecimal.valueOf(1));
		vo.setEmail("222213222@2332.com");
		
		service.insertUser(vo);
	}
	
	//@Test 
	public void testDelete() {
		service.deleteUser(2L);
		
	}
	
	//@Test
	public void testUserDetail() {
		log.info(service.userDetail(1L));
		
	}
	
	@Test
	void loadByTest() {
		
		UserDetails u = uService.loadUserByUsername("test3");
		log.info(u);
		log.info(u.getPassword());
	}

}
