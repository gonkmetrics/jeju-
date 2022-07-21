package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.ProductInfo;
import io.jejuwn.repository.ProductInfoRepository;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	
	@Autowired
	private ProductInfoRepository repository;
	
	// 상품 정보 전체를 불러오는 메서드
	@Override
	public List<ProductInfo> getProductInfoList() {
		return repository.findAll();
	}
	// 상품 정보 생성
	@Override
	public void productInfoInsert(ProductInfo vo) {
		repository.save(vo);
	}
	// 상품 정보 삭제
	@Override
	public void productInfoDelete(Long id) {
		repository.deleteById(id);
	}
	// 상품 정보 수정
	@Override
	public void productInfoUpdate(ProductInfo vo) {
		repository.save(vo);
	}
	// 특정 한개의 상품 정보 보기
	@Override
	public ProductInfo productInfoDetail(Long id) {
		ProductInfo productInfoDetail = repository.findById(id).get();
		return productInfoDetail;
	}

}
