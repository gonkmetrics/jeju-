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

import io.jejuwn.model.Product;
import io.jejuwn.service.ProductService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ProductServiceTest {
	
	@Autowired
	private ProductService service;
	
	// 모든 상품의 정보를 가져오는 메서드
	//@Test
	public void testProductList() {
		log.info(service.getProductList());
	}
	
	// 상품 생성
	//@Test
	public void testProductInsert() {
		Product vo = new Product();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setName("마스크");
		vo.setCategory(BigDecimal.valueOf(2));
		vo.setUserId(BigDecimal.valueOf(2));
		vo.setRegion(BigDecimal.valueOf(2));
		
		service.productInsert(vo);
	}
	
	// 상품 삭제
	//@Test
	public void testProductDelete() {
		service.productDelete(2L);
	}
	
	// 상품 정보 수정
	//@Test
	public void testProductUpdate() {
		Product vo = new Product();
		
		vo.setName("업데이트가능?");
		vo.setId(BigDecimal.valueOf(1));
		vo.setCategory(BigDecimal.valueOf(2));
		vo.setRegion(BigDecimal.valueOf(2));
		vo.setUserId(BigDecimal.valueOf(1));
		
		service.productUpdate(vo);
	}
	
	// 상품 한개의 정보 보기
	@Test
	public void testProductDetail() {
		service.productDetail(1L);
	}
}
