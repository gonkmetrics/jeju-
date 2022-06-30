package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.CartMapper;
import io.jejuwn.model.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper mapper;
	
	@Override
	public List<Cart> getAllCartList() {
		return mapper.selectByExample(null);
	}
	
	@Override
	public Cart getCartList(Long id){
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	@Override
	public void cartInsert(Cart vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void cartDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}

}
