package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.UserOrderMapper;
import io.jejuwn.model.UserOrder;

@Service
public class UserOrderServiceImpl implements UserOrderService {
	
	@Autowired
	private UserOrderMapper mapper;
	
	@Override
	public List<UserOrder> getAllUserOrderList() {
		return mapper.selectByExample(null);
	}
	
	@Override
	public void userOrderInsert(UserOrder vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void userOrderDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	@Override
	public void userOrderUpdate(UserOrder vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	@Override
	public List<UserOrder> userOrderList(Long userId) {
		return mapper.selectByExample(null);
	}
}
