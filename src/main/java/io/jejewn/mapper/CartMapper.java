package io.jejewn.mapper;

import io.jejewn.persistence.CartVO;

public interface CartMapper {
	
	public void insert(CartVO vo);
	
	public void delete(Long cId);
}
