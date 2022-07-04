package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.ProductLikeMapper;
import io.jejuwn.model.ProductLike;

@Service
public class ProductLikeServiceImpl implements ProductLikeService {
	
	@Autowired
	private ProductLikeMapper mapper;
	
	// 내 찜 불러오는 메서드 
	@Override
	public List<ProductLike> getProductLikeList(Long user_id){
		return mapper.selectByExample(null);
	}
	
	// 찜 생성
	@Override
	public void productLikeInsert(ProductLike vo) {
		mapper.insert(vo);
	}
	
	// 찜 삭제
	@Override
	public void productLikeDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	

}
