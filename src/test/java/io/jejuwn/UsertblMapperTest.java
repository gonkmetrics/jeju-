package io.jejuwn;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.mapper.UsertblMapper;
=======
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.mapper.UsertblMapper;
import io.jejuwn.model.Address;
>>>>>>> origin/merge_prep
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UsertblMapperTest {
	
	//@Test
	public void calculate1Plus1Gives2() {
		assertEquals(1+1,2);
	}
	
<<<<<<< HEAD

	@Autowired
	private UsertblMapper mapper;
	
	//@Test
=======
	private Address address;

	@Autowired
	private AddressMapper mapper;
	
	@Test
>>>>>>> origin/merge_prep
	  public void contextLoads() {
	    log.info(mapper);
	  }
	
<<<<<<< HEAD
	//@Test
	public void testSelect() {
		log.info(mapper.selectByPrimaryKey(BigDecimal.valueOf(1)));
	}
	
=======
	@Test
	public void testSelect() {
		address = mapper.selectByPrimaryKey(BigDecimal.valueOf(1));
		log.info("--------");
		log.info(address.toString());
	}
>>>>>>> origin/merge_prep
}
