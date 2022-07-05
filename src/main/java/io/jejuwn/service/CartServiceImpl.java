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
<<<<<<< HEAD
	public List<Cart> getCartList(Long userId){
		return mapper.selectByExample(null);
=======
	public Cart getCartList(Long cId){
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(cId));
>>>>>>> origin/merge_prep
	}
	
	@Override
	public void cartInsert(Cart vo) {
		mapper.insert(vo);
	}
	
	@Override
<<<<<<< HEAD
	public void cartDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
=======
	public void cartDelete(Long cId) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(cId));
>>>>>>> origin/merge_prep
	}

}
