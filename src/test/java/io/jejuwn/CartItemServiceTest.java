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

import io.jejuwn.model.CartItem;
import io.jejuwn.service.CartItemService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class CartItemServiceTest {
	
	@Autowired
	private CartItemService service;
	
	// 모든 장바구니 보기
	//@Test
	public void testGetAllCartItemList(){
		log.info(service.getAllCartItemList());
	}
	// 내 장바구니 목록보기	
	// public CartItem getCartItemList(Long cartId);
	// 장바구니 추가
	// @Test
	public void testCarItemInsert() {
		CartItem vo = new CartItem();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setItem(BigDecimal.valueOf(2));
		vo.setCartId(BigDecimal.valueOf(1));
		vo.setProductId(BigDecimal.valueOf(1));
		vo.setCategory(BigDecimal.valueOf(1));
		
		service.carItemInsert(vo);
	}
	// 장바구니 삭제
	@Test
	public void testCartItemDelete() {
		service.cartItemDelete(2L);
	}

}
