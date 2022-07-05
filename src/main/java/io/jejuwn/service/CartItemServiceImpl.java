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
<<<<<<< HEAD
	/*@Override
	public CartItem getCartItemList(Long cartId){
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(cartId));
	} */
=======
	@Override
	public CartItem getCartItemList(Long cId){
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(cId));
	}
>>>>>>> origin/merge_prep
	
	@Override
	public void carItemInsert(CartItem vo) {
		mapper.insert(vo);
	}
	
	@Override
<<<<<<< HEAD
	public void cartItemDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
=======
	public void cartItemDelete(Long ciId) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(ciId));
>>>>>>> origin/merge_prep
	}
	

}
