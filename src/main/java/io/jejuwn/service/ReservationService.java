package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.Reservation;


public interface ReservationService {
		
	// 모든 예약 목록 보기 기능
	public List<Reservation> getAllReservationList();
	
	// 예약
	public void ReservationInsert(Reservation vo);
	
	// 예약 삭제
	public void ReservationDelete(Long id);
	
	// 예약 수정
	public void ReservationUpdate(Reservation vo);
	
	// 유저의 예약 보기
	public List<Reservation> ReservationList(Long user_id);
	
}
