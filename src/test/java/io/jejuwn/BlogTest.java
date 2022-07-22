package io.jejuwn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.mapper.BlogExtMapper;
import io.jejuwn.model.BlogUserTest;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class BlogTest {
	
	@Autowired
	private BlogExtMapper mapper;
	
	//@Test
	public void blogUserTest() {
		BlogUserTest user = new BlogUserTest();
		
		user.setId(1L);
		user.setUserId(3L);
		user.setContent("되야합니다 되야해");
		user.setTitle("제목은 이거에요");
		
		mapper.insertBlog(user);
	}
	
	@Test
	public void blogUserUpdate() {
		BlogUserTest user = new BlogUserTest();
		
		user.setId(1L);
		user.setUserId(1L);
		user.setContent("업데이트 성공");
		user.setTitle("제목은 업데이트");
		
		mapper.updateBlog(user);
	}
}
