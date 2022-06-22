package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.AddressVO;

public interface AddressMapper {
	
	// 유저들의 주소 정보를 불러오는 메서드
	public List<AddressVO> getAddressList();
	
	// 유저 주소 생성
	public void insert(AddressVO vo);
	
	// 유저 주소 삭제
	public void delete(Long addId);
	
	// 유저 주소 수정
	public void update(AddressVO vo);
	
	// 유저 정보 상세 보기
	public AddressVO addressDetail(Long addId);
	
}
