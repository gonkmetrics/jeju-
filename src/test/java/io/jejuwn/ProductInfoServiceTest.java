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

import io.jejuwn.model.ProductInfo;
import io.jejuwn.service.ProductInfoService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ProductInfoServiceTest {
		
	@Autowired
	private ProductInfoService service;
	
	// 상품 정보 전체를 불러오는 메서드
	//@Test
	public void testProductInfoList() {
		log.info(service.getProductInfoList());
	}
	
	// 상품 정보 생성
	// @Test
	public void testProductInfoInsert() {
		ProductInfo vo = new ProductInfo();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setContent("가가가가가가나나나나나");
		vo.setContentExtra("가가");
		vo.setPrice(BigDecimal.valueOf(1000));
		vo.setHit(BigDecimal.valueOf(0));
		vo.setMaxCapacity(BigDecimal.valueOf(1));
		vo.setAddress("경기도");
		
		service.productInfoInsert(vo);
	}
	
	// 상품 정보 삭제
	//@Test
	public void testProductInfoDelete() {
		service.productInfoDelete(2L);
		
	}
	
	// 상품 정보 수정
	//@Test
	public void testProductInfoUpdate() {
		ProductInfo vo = new ProductInfo();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setContent("나나나나나나나나나나나");
		vo.setContentExtra("나나");
		vo.setPrice(BigDecimal.valueOf(200));
		vo.setHit(BigDecimal.valueOf(100));
		vo.setMaxCapacity(BigDecimal.valueOf(1));
		vo.setAddress("서울");
		
		service.productInfoUpdate(vo);
	}
	
	// 특정 한개의 상품 정보 보기
	@Test
	public void testProductInfoDetail() {
		log.info(service.productInfoDetail(2L));
	}
}
