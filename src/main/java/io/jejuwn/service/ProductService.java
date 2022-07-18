package io.jejuwn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Product;


public interface ProductService {
		
	
	// 모든 상품의 정보를 가져오는 메서드
	public List<Product> getProductList();
	
	// 상품 생성
	public void productInsert(Product vo);
	
	// 상품 삭제
	public void productDelete(Long id);
	
	// 상품 정보 수정
	public void productUpdate(Product vo);
	
	// 상품 한개의 정보 보기
	public Product productDetail(Long id);
	
	public List<Product> getProductList2();
	public Page<Product> productList(Pageable pageable);
	
}
