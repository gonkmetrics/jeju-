package io.jejuwn;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.mapper.UsertblMapper;
import io.jejuwn.model.Address;
import io.jejuwn.service.AddressService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class AddressServiceTest {
	
	Address address;

	@Autowired
	private AddressService service;
	
	@Test
	  public void contextLoads() {
	    log.info(service);
	  }
	
	@Test
	public void testSelect() {
		address = service.addressDetail(1L);
		log.info("--------");
		log.info(address.toString());
	}
}
