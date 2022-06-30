package io.jejuwn;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class JejuwnBApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void mesg() {
		log.info("contextloads mesg:");
		log.info(BigDecimal.valueOf(12));
	}

}
