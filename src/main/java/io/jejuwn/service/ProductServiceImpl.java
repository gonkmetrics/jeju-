package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Product;
import io.jejuwn.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	// 모든 상품의 정보를 가져오는 메서드
	@Override
	public List<Product> getProductList(){
		return repository.findAll();
	}
	// 상품 생성
	@Override
	public void productInsert(Product vo) {
		repository.save(vo);
	}
	// 상품 삭제
	@Override
	public void productDelete(Long id) {
		repository.deleteById(id);
	}
	// 상품 정보 수정
	@Override
	public void productUpdate(Product vo) {
		repository.save(vo);
	}
	// 상품 한개의 정보 보기
	@Override
	public Product productDetail(Long id) {
		Product productDetail = repository.findById(id).get();
		return productDetail;
	}

}
