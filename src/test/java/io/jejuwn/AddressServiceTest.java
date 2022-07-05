package io.jejuwn;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

=======
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
>>>>>>> origin/merge_prep
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
=======
import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.mapper.UsertblMapper;
>>>>>>> origin/merge_prep
import io.jejuwn.model.Address;
import io.jejuwn.service.AddressService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
<<<<<<< HEAD
class AddressServiceTest {
	
	@Autowired
	private AddressService service;
	
	// 유저들의 주소 정보를 불러오는 메서드
	// @Test
	public void testgetAddressList() {
		log.info(service.getAddressList());
	}
	
	// 유저 주소 생성
	//@Test
	public void testaddressInsert() {
		Address vo = new Address();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setId(BigDecimal.valueOf(2));
		vo.setAddressLine1("경기도");
		vo.setAddressLine2("시흥시");
		vo.setCity("경기도");
		vo.setPostalCode("111");
		vo.setPhone("01011112222");
		
		service.addressInsert(vo);
	}
	
	// 유저 주소 삭제
	//@Test
	public void testaddressDelete() {
		service.addressDelete(2L);
	}
	
	// 유저 주소 수정
	// @Test
	public void testaddressUpdate() {
		Address vo = new Address();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setId(BigDecimal.valueOf(2));
		vo.setAddressLine1("경기도");
		vo.setAddressLine2("시흥시");
		vo.setCity("한국");
		vo.setPostalCode("111");
		vo.setPhone("01011112222");
		
		service.addressUpdate(vo);
	}
	
	// 유저 정보 상세 보기
	// @Test
	 public void testaddressDetail() {
		service.addressDetail(2L);
	}
	
	//@Test
	void test() {
		fail("Not yet implemented");
	}

=======
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
>>>>>>> origin/merge_prep
}
