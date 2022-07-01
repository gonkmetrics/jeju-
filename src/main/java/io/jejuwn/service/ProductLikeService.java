package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.ProductLike;

public interface ProductLikeService {
		
	
	// 내 찜 불러오는 메서드 
	public List<ProductLike> getProductLikeList(Long user_id);
	
	// 찜 생성
	public void productLikeInsert(ProductLike vo);
	
	// 찜 삭제
	public void productLikeDelete(Long id);
	
}
