package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.CartItem;
import io.jejuwn.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository repository;
	
	@Override
	public List<CartItem> getAllCartItemList(){
		return repository.findAll();
	}
	/*@Override
	public CartItem getCartItemList(Long cartId){
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(cartId));
	} */
	
	@Override
	public void carItemInsert(CartItem vo) {
		repository.save(vo);
	}
	
	@Override
	public void cartItemDelete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<CartItem> getAllCartItemByCartId(Long id) {
		// TODO Auto-generated method stub
		List<Long> iterable = Arrays.asList(id);
		return repository.findAllById(iterable);
	}
	

}
