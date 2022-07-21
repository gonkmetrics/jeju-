package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import io.jejuwn.model.UserOrder;
import io.jejuwn.repository.UserOrderRepository;


@Service
public class UserOrderServiceImpl implements UserOrderService {
	
	@Autowired
	private UserOrderRepository repository;
	
	@Override
	public List<UserOrder> getAllUserOrderList() {
		return repository.findAll();
	}
	
	@Override
	public void userOrderInsert(UserOrder vo) {
		repository.save(vo);
	}
	
	@Override
	public void userOrderDelete(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public void userOrderUpdate(UserOrder vo) {
		repository.save(vo);
	}
	
	//GET ALL UNDER ID
	@Override
	public List<UserOrder> userOrderList(Long userId) {
		return null;
	}
}
