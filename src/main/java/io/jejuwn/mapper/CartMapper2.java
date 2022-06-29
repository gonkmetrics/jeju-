package io.jejuwn.mapper;

import java.util.List;

import io.jejuwn.persistence.CartVO;

public interface CartMapper2 {
	
	// 카트 리스트 전부를 불러오는 메서드
	public List<CartVO> getAllCartList();
	// 내 카트 리스트 불러오는 메서드
	public List<CartVO> getCartList(Long cId);
	
	public void insert(CartVO vo);
	
	public void delete(Long cId);
}
