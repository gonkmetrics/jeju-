package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.jejuwn.mapper.ProductInfoMapper;
import io.jejuwn.model.ProductInfo;

public class ProductInfoServiceImpl implements ProductInfoService {
	
	@Autowired
	private ProductInfoMapper mapper;
	
	// 상품 정보 전체를 불러오는 메서드
	public List<ProductInfo> getProductInfoList() {
		return mapper.selectByExample(null);
	}
	// 상품 정보 생성
	public void productInfoInsert(ProductInfo vo) {
		mapper.insert(vo);
	}
	// 상품 정보 삭제
	public void productInfoDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	// 상품 정보 수정
	public void productInfoUpdate(ProductInfo vo) {
		mapper.updateByPrimaryKey(vo);
	}
	// 특정 한개의 상품 정보 보기 
	public ProductInfo productInfoDetail(Long id) {
		ProductInfo productInfoDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
		return productInfoDetail;
	}

}
