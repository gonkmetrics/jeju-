package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.CartItemVO;

public interface CartItemMapper {
	
	public List<CartItemVO> getAllCartItemList();
	// 한 유저의 장바구니를 불러오는 메서드
	public List<CartItemVO> getCartItemList(Long cId);
	
	public void insert(CartItemVO vo);
	
	public void delete(Long ciId);
}
