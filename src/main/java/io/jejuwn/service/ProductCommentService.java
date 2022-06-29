package io.jejuwn.service;

import java.util.List;

import io.jejuwn.persistence.ProductCommentVO;

public interface ProductCommentService {
		
	// pId 번의 댓글 전체 가져오는 기능
	public List<ProductCommentVO> getProductCommentList(Long pId);
	
	// 댓글 추가 기능
	public void insertProductComment(ProductCommentVO vo);
	
	// 댓글 수정 기능
	public void updateProductComment(ProductCommentVO vo);
	
	// 댓글 삭제 기능
	public void deleteProdcutComment(Long pId);
	
}
