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

import io.jejuwn.model.Cart;
import io.jejuwn.service.CartService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class CartServiceTest {
	
	@Autowired
	private CartService service;
	
	// 카트 리스트 전부를 불러오는 메서드
	//@Test
	public void testGetAllCartList(){
		log.info(service.getAllCartList());
	}
	// 내 카트 리스트 불러오는 메서드
	// @Test
	public void testGetCartList() {
		log.info(service.getCartList(3L));
	}
	// insert
	// @Test
	public void testCartInsert() {
		Cart vo = new Cart();
		
		vo.setId(BigDecimal.valueOf(4));
		vo.setToken(BigDecimal.valueOf(4));
		vo.setUserId(BigDecimal.valueOf(2));
		
		service.cartInsert(vo);
	}
	// delete
	//@Test
	public void testCartDelete() {
		service.cartDelete(4L);
	}

}
