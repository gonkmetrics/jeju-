package io.jejuwn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.CartItemMapper;
import io.jejuwn.persistence.CartItemVO;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemMapper mapper;
	
	@Override
	public List<CartItemVO> getAllCartItemList(){
		return mapper.getAllCartItemList();
	}
	@Override
	public List<CartItemVO> getCartItemList(Long cId){
		return mapper.getCartItemList(cId);
	}
	
	@Override
	public void carItemInsert(CartItemVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void cartItemDelete(Long ciId) {
		mapper.delete(ciId);
	}
	

}
