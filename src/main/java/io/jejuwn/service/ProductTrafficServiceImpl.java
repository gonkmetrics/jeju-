package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.ProductTraffic;
import io.jejuwn.repository.ProductTrafficRepository;

@Service
public class ProductTrafficServiceImpl implements ProductTrafficService {
	
		@Autowired
		private ProductTrafficRepository repository;
		
		// product 교통 전체 리스트
		@Override
		public List<ProductTraffic> getProductTrafficList() {
			return repository.findAll();
		}
		
		// 교통 정보 생성
		@Override
		public void productTrafficInsert(ProductTraffic vo) {
			repository.save(vo);
		}
		
		// 교통 정보 삭제
		@Override
		public void productTrafficDelete(Long id) {
			repository.deleteById(id);
		}
		
		// 교통 정보 수정
		@Override
		public void productTrafficUpdate(ProductTraffic vo) {
			repository.save(vo);
		}
		
		// 교통 정보 자세히 보기
		@Override
		public ProductTraffic productTrafficDetail(Long id) {
			ProductTraffic productTrafficDetail = repository.findById(id).get();
			return productTrafficDetail;
		}

}
