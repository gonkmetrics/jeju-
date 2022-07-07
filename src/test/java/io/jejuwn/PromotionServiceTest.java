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

import io.jejuwn.model.Promotion;
import io.jejuwn.service.PromotionService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class PromotionServiceTest {
	
	@Autowired
	private PromotionService service;
	
	// Promotion 전체 리스트
	// @Test
	public void testGetPromotionList(){
		log.info(service.getPromotionList());
	}
	
	// Promotion 생성
	// @Test
	public void testPromotionInsert() {
		Promotion vo = new Promotion();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setCode("10%");
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setPromotionValue(BigDecimal.valueOf(1));
		
		service.promotionInsert(vo);
	}
	
	// Promotion 삭제
	// @Test
	public void promotionDelete() {
		service.promotionDelete(1L);
	}
	
	// Promotion 수정
	// @Test
	public void testPromotionUpdate() {
		Promotion vo = new Promotion();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setCode("50%");
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setPromotionValue(BigDecimal.valueOf(1));
		
		service.promotionUpdate(vo);
	}

}
