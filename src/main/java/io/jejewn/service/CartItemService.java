package io.jejewn.service;

import java.util.List;

import io.jejewn.persistence.CartItemVO;

public interface CartItemService {
		
	// 장바구니 목록보기	
	public List<CartItemVO> getCartItemList(Long ciId);
	// 장바구니 추가
	public void carItemInsert(CartItemVO vo);
	// 장바구니 삭제
	public void cartItemDelete(Long ciId);
}
