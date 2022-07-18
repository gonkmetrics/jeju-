package io.jejuwn.service;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.ProductMapper;
import io.jejuwn.model.Product;
import io.jejuwn.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	// 모든 상품의 정보를 가져오는 메서드
	@Override
	public List<Product> getProductList(){
		return mapper.selectByExample(null);
	}
	@Override
	public List<Product> getProductList2(){
		return productRepository.findAll();
	}
	// 상품 생성
	@Override
	public void productInsert(Product vo) {
		mapper.insert(vo);
	}
	// 상품 삭제
	@Override
	public void productDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	// 상품 정보 수정
	@Override
	public void productUpdate(Product vo) {
		mapper.updateByPrimaryKey(vo);
	}
	// 상품 한개의 정보 보기
	@Override
	public Product productDetail(Long id) {
		Product productDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
		return productDetail;
	}
	@Override
	public Page<Product> productList(Pageable pageable){
		return productRepository.findAll(pageable);
	}

}
