package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.ReservationMapper;
import io.jejuwn.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	@Autowired
	private ReservationMapper mapper;
	
	// 모든 예약 목록 보기 기능
	@Override
	public List<Reservation> getAllReservationList() {
		return mapper.selectByExample(null);
	}
	
	// 예약
	@Override
	public void ReservationInsert(Reservation vo) {
		mapper.insert(vo);
	}
	
	// 예약 삭제
	@Override
	public void ReservationDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	// 예약 수정
	@Override
	public void ReservationUpdate(Reservation vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	// 유저의 예약 보기
	@Override
	public List<Reservation> ReservationList(Long userId) {
		return mapper.selectByExample(null);
	}

}
