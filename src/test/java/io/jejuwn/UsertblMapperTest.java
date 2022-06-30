package io.jejuwn;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.mapper.UsertblMapper;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UsertblMapperTest {
	
	@Test
	public void calculate1Plus1Gives2() {
		assertEquals(1+1,2);
	}
	

	@Autowired
	private UsertblMapper mapper;
	
	@Test
	  public void contextLoads() {
	    log.info(mapper);
	  }
	
	@Test
	public void testSelect() {
		log.info(mapper.selectByPrimaryKey(BigDecimal.valueOf(1)));
	}
}
