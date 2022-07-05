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
import io.jejuwn.mapper.BlogUserTestMapper;
import io.jejuwn.model.BlogUserTest;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class BlogMapperExtTest {
	
	@Autowired
	private BlogMapperExt mapper;
	
	@Autowired
	private BlogUserTestMapper mapper2;
	
	//@Test
	  public void contextLoads() {
	    log.info(mapper);
	  }
	
	//@Test
		void createTable() {
		mapper.createBlogTable(BigDecimal.valueOf(1));
	}
	
	@Test
	void insertTable() {
	BlogUserTest obj = new BlogUserTest();
	obj.setContent("abc");
	obj.setId(BigDecimal.valueOf(1));
	obj.setTitle("abc");
	obj.setUserId(BigDecimal.valueOf(1));
	obj.setRegdate(null);
	obj.setUpdatedate(null);
	log.info(obj.getContent());
	mapper2.insert(obj);
}

}
