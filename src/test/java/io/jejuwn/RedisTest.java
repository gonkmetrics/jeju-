package io.jejuwn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.Usertbl;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@RunWith(SpringRunner.class)
@Log4j2
public class RedisTest {
	
	@Autowired private RedisTemplate<String, Object> redisTemplate;

	//@Test
	void savetoRedis() {
		
		redisTemplate.opsForValue()
        .set("testname", "testToken", 100, TimeUnit.MILLISECONDS);
		
	}
	
	//@Test
	void getFromRedis() {
		log.info(redisTemplate.opsForValue().get("testname"));
		
	}
	
	@Test
	void deleteFromRedis() {
		redisTemplate.opsForValue()
        .set("test2", "", 1, TimeUnit.MILLISECONDS);
	}

}
