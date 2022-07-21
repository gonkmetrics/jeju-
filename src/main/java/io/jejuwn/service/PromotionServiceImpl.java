package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Promotion;
import io.jejuwn.repository.PromotionRepository;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private PromotionRepository repository;
	
	// Promotion 전체 리스트
	public List<Promotion> getPromotionList() {
		return repository.findAll();
	}
	
	// Promotion 생성
	public void promotionInsert(Promotion vo) {
		repository.save(vo);
	}
	
	// Promotion 삭제
	public void promotionDelete(Long id) {
		repository.deleteById(id);
	}
	
	// Promotion 수정
	public void promotionUpdate(Promotion vo) {
		repository.save(vo);
	}

}
