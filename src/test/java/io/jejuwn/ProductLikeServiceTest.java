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

import io.jejuwn.model.ProductLike;
import io.jejuwn.service.ProductLikeService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ProductLikeServiceTest {
	
	@Autowired
	private ProductLikeService service;
	
	// 내 찜 불러오는 메서드
	//@Test
	public void testGetProductLikeList() {
		log.info(service.getProductLikeList(1L));
	}
	
	// 찜 생성
	//@Test
	public void testProductLikeInsert() {
		ProductLike vo = new ProductLike();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setProductId(BigDecimal.valueOf(3));
		vo.setUserId(BigDecimal.valueOf(3));
		
		service.productLikeInsert(vo);
	}
	
	// 찜 삭제
	//@Test
	public void testProductLikeDelete() {
		service.productLikeDelete(1L);
	}

}
