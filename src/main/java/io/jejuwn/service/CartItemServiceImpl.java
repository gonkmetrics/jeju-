package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.CartItemMapper;
import io.jejuwn.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemMapper mapper;
	
	@Override
	public List<CartItem> getAllCartItemList(){
		return mapper.selectByExample(null);
	}
	@Override
	public CartItem getCartItemList(Long id){
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	@Override
	public void carItemInsert(CartItem vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void cartItemDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	

}
