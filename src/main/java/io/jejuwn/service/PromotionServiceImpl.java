package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.PromotionMapper;
import io.jejuwn.model.Promotion;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private PromotionMapper mapper;
	
	// Promotion 전체 리스트
	public List<Promotion> getPromotionList() {
		return mapper.selectByExample(null);
	}
	
	// Promotion 생성
	public void promotionInsert(Promotion vo) {
		mapper.insert(vo);
	}
	
	// Promotion 삭제
	public void promotionDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	// Promotion 수정
	public void promotionUpdate(Promotion vo) {
		mapper.updateByPrimaryKey(vo);
	}

}
