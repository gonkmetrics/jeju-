package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.ReservationVO;

public interface ReservationMapper {

	public List<ReservationVO> getList(Long rId);
	
	public void insert(ReservationVO vo);
	
	public void delete(Long rId);
	
	public void update(ReservationVO vo);
	
	public ReservationVO getDetail(Long rId);
}
