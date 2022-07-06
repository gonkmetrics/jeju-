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

import io.jejuwn.model.ProductComment;
import io.jejuwn.service.ProductCommentService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ProductCommentServiceTest {
	
	@Autowired
	private ProductCommentService service;
	
	// product_id 번의 댓글 전체 가져오는 기능
	@Test
	public void testGetProductCommentList() {
		log.info(service.getProductCommentList(3L));
	}
	
	// 댓글 추가 기능
	//@Test
	public void testInsertProductComment() {
		ProductComment vo = new ProductComment();
		
		vo.setId(BigDecimal.valueOf(3));
		vo.setContent("댓글eeee");
		vo.setUserId(BigDecimal.valueOf(1));
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setRating(BigDecimal.valueOf(4));
		
		service.insertProductComment(vo);
	}
	
	// 댓글 수정 기능
	// @Test
	public void updateProductComment() {
		ProductComment vo = new ProductComment();
		
		vo.setId(BigDecimal.valueOf(3));
		vo.setContent("댓글수정");
		vo.setUserId(BigDecimal.valueOf(1));
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setRating(BigDecimal.valueOf(2));
		
		service.updateProductComment(vo);
	}
	
	// 댓글 삭제 기능
	// @Test
	public void deleteProdcutComment() {
		service.deleteProdcutComment(2L);
	}

}
