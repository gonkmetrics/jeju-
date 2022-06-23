package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.CartItemVO;

public interface CartItemMapper {
	
	public List<CartItemVO> getCartItemList(Long ciId);
	
	public void insert(CartItemVO vo);
	
	public void delete(Long ciId);
}
