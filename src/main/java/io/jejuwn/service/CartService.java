package io.jejuwn.service;

import java.util.List;

import io.jejuwn.persistence.CartVO;

public interface CartService {
	
	// 카트 리스트 전부를 불러오는 메서드
	public List<CartVO> getAllCartList();
	// 내 카트 리스트 불러오는 메서드
	public List<CartVO> getCartList(Long cId);
	
	public void cartInsert(CartVO vo);
	
	public void cartDelete(Long cId);
}
