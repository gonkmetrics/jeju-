package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.jejuwn.mapper.ProductMapper;
import io.jejuwn.model.Product;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	// 모든 상품의 정보를 가져오는 메서드
	public List<Product> getProductList(){
		return mapper.selectByExample(null);
	}
	// 상품 생성
	public void productInsert(Product vo) {
		mapper.insert(vo);
	}
	// 상품 삭제
	public void productDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	// 상품 정보 수정
	public void productUpdate(Product vo) {
		mapper.updateByPrimaryKey(vo);
	}
	// 상품 한개의 정보 보기
	public Product productDetail(Long id) {
		Product productDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
		return productDetail;
	}

}
