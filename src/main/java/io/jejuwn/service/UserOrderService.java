package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.UserOrder;

public interface UserOrderService {
	
	
	// 모든 주문내역 불러오는 메서드
	public List<UserOrder> getAllUserOrderList();
	
	// 유저 주문내역 생성
	public void userOrderInsert(UserOrder vo);
	
	// 유저 주문내역 삭제
	public void userOrderDelete(Long id);
	
	// 유저 주문내역 수정
	public void userOrderUpdate(UserOrder vo);
	
	// 한 유저의 주문내역 보기
	public List<UserOrder> userOrderList(Long userId);
}
