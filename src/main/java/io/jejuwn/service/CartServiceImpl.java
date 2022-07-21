package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Cart;
import io.jejuwn.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository repository;
	
	@Override
	public List<Cart> getAllCartList() {
		return repository.findAll();
	}
	
	@Override
	public Cart getCart(Long userId){
		return repository.findById(userId).get();
	}
	
	@Override
	public void cartInsert(Cart vo) {
		repository.save(vo);
	}
	
	@Override
	public void cartDelete(Long id) {
		repository.deleteById(id);;
	}

}
