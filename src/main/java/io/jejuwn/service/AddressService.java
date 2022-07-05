package io.jejuwn.service;

import java.util.List;


import io.jejuwn.model.Address;

public interface AddressService {
	
	// 유저들의 주소 정보를 불러오는 메서드
	public List<Address> getAddressList();
	
	// 유저 주소 생성
	public void addressInsert(Address vo);
	
	// 유저 주소 삭제
	public void addressDelete(Long id);
	
	// 유저 주소 수정
	public void addressUpdate(Address vo);
	
	// 유저 주소 상세 보기
	public Address addressDetail(Long userId);
	
	
}
