package io.jejuwn;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.mapper.BlogMapperExt;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class BlogMapperExtTest {
	
	@Autowired
	private BlogMapperExt mapper;
	
	@Test
	  public void contextLoads() {
	    log.info(mapper);
	  }
	
	@Test
		void createTable() {
		mapper.createBlogTable(BigDecimal.valueOf(1));
	}

}
