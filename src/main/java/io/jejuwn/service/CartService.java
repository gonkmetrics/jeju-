package io.jejuwn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.jejuwn.model.Cart;

public interface CartService {
	
	// 카트 리스트 전부를 불러오는 메서드
	public List<Cart> getAllCartList();
	// 내 카트 리스트 불러오는 메서드
<<<<<<< HEAD
	public List<Cart> getCartList(Long userId);
	
	public void cartInsert(Cart vo);
	
	public void cartDelete(Long id);
=======
	public Cart getCartList(Long cId);
	
	public void cartInsert(Cart vo);
	
	public void cartDelete(Long cId);
>>>>>>> origin/merge_prep
}
