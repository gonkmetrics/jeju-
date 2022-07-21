package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.ProductLike;
import io.jejuwn.repository.ProductLikeRepository;

@Service
public class ProductLikeServiceImpl implements ProductLikeService {
	
	@Autowired
	private ProductLikeRepository repository;
	
	// 내 찜 불러오는 메서드 
	@Override
	public List<ProductLike> getProductLikeList(Long userId){
		return repository.findAll();
	}
	
	// 찜 생성
	@Override
	public void productLikeInsert(ProductLike vo) {
		repository.save(vo);
	}
	
	// 찜 삭제
	@Override
	public void productLikeDelete(Long id) {
		repository.deleteById(id);
	}
	
	//add code to select by post id
	

}
