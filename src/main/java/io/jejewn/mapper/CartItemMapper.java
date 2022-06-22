package io.jejewn.mapper;

import io.jejewn.persistence.CartItemVO;

public interface CartItemMapper {
	
	public void insert(CartItemVO vo);
	
	public void delete(Long ciId);
}
