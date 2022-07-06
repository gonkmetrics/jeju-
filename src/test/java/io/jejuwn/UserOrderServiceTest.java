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

import io.jejuwn.model.UserOrder;
import io.jejuwn.service.UserOrderService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserOrderServiceTest {
	
	@Autowired
	private UserOrderService service;
	
	// 유저의 주문내역 전체를 불러오는 메서드
	@Test
	 public void testGetAllUserOrderList(){
		 log.info(service.getAllUserOrderList());
	}
	
	// 유저 주문내역 생성
	// @Test
	public void userOrderInsert() {
		UserOrder vo = new UserOrder();
		
		vo.setId(BigDecimal.valueOf(3));
		vo.setToken(BigDecimal.valueOf(3));
		vo.setUserId(BigDecimal.valueOf(1));
		vo.setCartId(BigDecimal.valueOf(1));
		vo.setAddressId(BigDecimal.valueOf(1));
		vo.setStatus(BigDecimal.valueOf(1));
		vo.setPromotionId(BigDecimal.valueOf(1));
		
		service.userOrderInsert(vo);
	}
	
	// 유저 주문내역 삭제
	// @Test
	public void testUserOrderDelete() {
		service.userOrderDelete(3L);
	}
	
	// 유저 주문내역 수정
	// @Test
	public void testUserOrderUpdate() {
		UserOrder vo = new UserOrder();
		
		vo.setId(BigDecimal.valueOf(2));
		vo.setToken(BigDecimal.valueOf(5));
		vo.setUserId(BigDecimal.valueOf(1));
		vo.setCartId(BigDecimal.valueOf(1));
		vo.setAddressId(BigDecimal.valueOf(1));
		vo.setStatus(BigDecimal.valueOf(1));
		vo.setPromotionId(BigDecimal.valueOf(1));
		
		service.userOrderUpdate(vo);
	}
	
	// 한 유저의 주문내역 보기
	@Test
	public void testUserOrderList() {
		log.info(service.userOrderList(2L));
	}

}
