package io.jejewn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejewn.mapper.CartMapper;
import io.jejewn.persistence.CartVO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper mapper;
	
	@Override
	public List<CartVO> getAllCartList() {
		return mapper.getAllCartList();
	}
	
	@Override
	public List<CartVO> getCartList(Long cId){
		return mapper.getCartList(cId);
	}
	
	@Override
	public void cartInsert(CartVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void cartDelete(Long cId) {
		mapper.delete(cId);
	}

}
