package io.jejuwn;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.jejuwn.model.ProductTraffic;
import io.jejuwn.service.ProductTrafficService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ProductTrafficServiceTest {
	
	@Autowired
	private ProductTrafficService service;
	
	// product 교통 전체 리스트
	//@Test
	public void testGetProductTrafficList() {
		log.info(service.getProductTrafficList());
	}
	
	// 교통 정보 생성
	// @Test
	public void testProductTrafficInsert() {
		ProductTraffic vo = new ProductTraffic();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setLatitude("10");
		vo.setLongitude("20");
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setKeyword("제주");
		
		service.productTrafficInsert(vo);
		
	}
	
	// 교통 정보 삭제
	// @Test
	public void testProductTrafficDelete() {
		service.productTrafficDelete(1L);
	}
	
	// 교통 정보 수정
	// @Test
	public void testProductTrafficUpdate() {
		ProductTraffic vo = new ProductTraffic();
		
		vo.setId(BigDecimal.valueOf(1));
		vo.setLatitude("10");
		vo.setLongitude("100");
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setKeyword("서울");
		
		service.productTrafficUpdate(vo);
	}
	
	// 교통 정보 자세히 보기
	// @Test
	public void testProductTrafficDetail() {
		log.info(service.productTrafficDetail(2L));
	}

}
