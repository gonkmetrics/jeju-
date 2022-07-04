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
import io.jejuwn.service.UsertblService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserServiceTest {
	
	@Autowired
	private UsertblService service;
	
	//@Test
	public void testGetList() {
		log.info(service.listUser());
	}
	
	@Test
	public void testInsert() {
		Usertbl vo = new Usertbl();
		
		vo.setId(BigDecimal.valueOf(3));
		vo.setName("eewqq");
		vo.setNick("구구구");
		vo.setPass("1111");
		vo.setGender(BigDecimal.valueOf(1));
		vo.setAge(BigDecimal.valueOf(21));
		vo.setEmail("222213222@2332.com");
		vo.setRole(BigDecimal.valueOf(1));
		
		service.insertUser(vo);
		log.info(service.listUser());
	}
	
	//@Test
	public void testDelete() {
		service.deleteUser(1L);
		
	}
	
	//@Test
	public void testuserDetail() {
		service.userDetail(1L);
		
	}

}
