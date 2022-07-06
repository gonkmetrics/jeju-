package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.Promotion;


public interface PromotionService {
	
	// Promotion 전체 리스트
	public List<Promotion> getPromotionList();
	
	// Promotion 생성
	public void promotionInsert(Promotion vo);
	
	// Promotion 삭제
	public void promotionDelete(Long id);
	
	// Promotion 수정
	public void promotionUpdate(Promotion vo);
}
