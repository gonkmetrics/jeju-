package io.jejuwn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.jejuwn.model.ProductComment;

public interface ProductCommentService {
		
	// product_id 번의 댓글 전체 가져오는 기능
	public List<ProductComment> getProductCommentList(Long productId);
	
	// 댓글 추가 기능
	public void insertProductComment(ProductComment vo);
	
	// 댓글 수정 기능
	public void updateProductComment(ProductComment vo);
	
	// 댓글 삭제 기능
	public void deleteProdcutComment(Long id);
	
}
