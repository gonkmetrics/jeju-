package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Reservation;
import io.jejuwn.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	@Autowired
	private ReservationRepository repository;
	
	// 모든 예약 목록 보기 기능
	@Override
	public List<Reservation> getAllReservationList() {
		return repository.findAll();
	}
	
	// 예약
	@Override
	public void ReservationInsert(Reservation vo) {
		repository.save(vo);
	}
	
	// 예약 삭제
	@Override
	public void ReservationDelete(Long id) {
		repository.deleteById(id);
	}
	
	// 예약 수정
	@Override
	public void ReservationUpdate(Reservation vo) {
		repository.save(vo);
	}

	@Override
	public List<Reservation> ReservationList(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 유저의 예약 보기 GET ALL UNDER ID
	//@Override
	//public List<Reservation> ReservationList(Long userId) {
	//	return repository;
	//}

}
