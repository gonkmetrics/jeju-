package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.ProductTrafficMapper;
import io.jejuwn.model.ProductTraffic;

@Service
public class ProductTrafficServiceImpl implements ProductTrafficService {
	
		@Autowired
		private ProductTrafficMapper mapper;
		
		// product 교통 전체 리스트
		@Override
		public List<ProductTraffic> getProductTrafficList() {
			return mapper.selectByExample(null);
		}
		
		// 교통 정보 생성
		@Override
		public void productTrafficInsert(ProductTraffic vo) {
			mapper.insert(vo);
		}
		
		// 교통 정보 삭제
		@Override
		public void productTrafficDelete(Long id) {
			mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
		}
		
		// 교통 정보 수정
		@Override
		public void productTrafficUpdate(ProductTraffic vo) {
			mapper.updateByPrimaryKey(vo);
		}
		
		// 교통 정보 자세히 보기
		@Override
		public ProductTraffic productTrafficDetail(Long id) {
			ProductTraffic productTrafficDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
			return productTrafficDetail;
		}

}
