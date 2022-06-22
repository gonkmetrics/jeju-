package io.jejewn.service;

import java.util.List;

import io.jejewn.persistence.ReservationVO;

public interface ReservationService {

	public void addReservation(ReservationVO vo);
	public List<ReservationVO> listReservation(Long pId);
	public void modifyReservation(ReservationVO vo);
	public void removeReservation(Long rId);
	
}
