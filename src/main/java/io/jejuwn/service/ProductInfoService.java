package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.ProductInfo;

public interface ProductInfoService {
	
	// 상품 정보 전체를 불러오는 메서드
	public List<ProductInfo> getProductInfoList();
	
	// 상품 정보 생성
	public void productInfoInsert(ProductInfo vo);
	
	// 상품 정보 삭제
	public void productInfoDelete(Long id);
	
	// 상품 정보 수정
	public void productInfoUpdate(ProductInfo vo);
	
	// 특정 한개의 상품 정보 보기 
	public ProductInfo productInfoDetail(Long id);
}
