package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.ProductTraffic;

public interface ProductTrafficService {
			
		// product 교통 전체 리스트
		public List<ProductTraffic> getProductTrafficList();
		
		// 교통 정보 생성
		public void productTrafficInsert(ProductTraffic vo);
		
		// 교통 정보 삭제
		public void productTrafficDelete(Long id);
		
		// 교통 정보 수정
		public void productTrafficUpdate(ProductTraffic vo);
		
		// 교통 정보 자세히 보기
		public ProductTraffic productTrafficDetail(Long id);
}
