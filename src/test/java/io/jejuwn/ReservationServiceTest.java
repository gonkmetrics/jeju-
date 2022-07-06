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

import io.jejuwn.model.Reservation;
import io.jejuwn.service.ReservationService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService service;
	
	// 모든 예약 목록 보기 기능
	// @Test
	public void testGetAllReservationList() {
		log.info(service.getAllReservationList());
	}
	
	// 예약
	//@Test
	public void testReservationInsert(){
		Reservation vo = new Reservation();
		
		vo.setId(BigDecimal.valueOf(3));
		vo.setName("22232332321");
		vo.setUserId(BigDecimal.valueOf(2));
		vo.setReservation(BigDecimal.valueOf(1));
		vo.setStatus(BigDecimal.valueOf(3));
		vo.setProductId(BigDecimal.valueOf(1));
		
		service.ReservationInsert(vo);
	}
	
	// 예약 삭제
	// @Test
	public void testReservationDelete() {
		service.ReservationDelete(2L);
	}
	
	// 예약 수정
	// @Test
	public void testReservationUpdate(){
		Reservation vo = new Reservation();
		
		vo.setId(BigDecimal.valueOf(1));
		vo.setName("22313");
		vo.setUserId(BigDecimal.valueOf(1));
		vo.setReservation(BigDecimal.valueOf(1));
		vo.setStatus(BigDecimal.valueOf(2));
		vo.setProductId(BigDecimal.valueOf(1));
		
		service.ReservationUpdate(vo);
	}
	
	// 유저의 예약 보기
	// @Test
	public void testReservationList() {
		log.info(service.ReservationList(1L));
	}
}
