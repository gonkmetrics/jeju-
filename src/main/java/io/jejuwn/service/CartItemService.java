package io.jejuwn.service;

import java.util.List;

import io.jejuwn.persistence.CartItemVO;

public interface CartItemService {
	
	// 모든 장바구니 보기
	public List<CartItemVO> getAllCartItemList();
	// 내 장바구니 목록보기	
	public List<CartItemVO> getCartItemList(Long cId);
	// 장바구니 추가
	public void carItemInsert(CartItemVO vo);
	// 장바구니 삭제
	public void cartItemDelete(Long ciId);
}
