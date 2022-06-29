package io.jejuwn.mapper;

import java.util.List;

import io.jejuwn.persistence.ProductCommentVO;

public interface ProductCommentMapper2 {
		
	// pId번 글의 전체 댓글 목록 가져오기.
	public List<ProductCommentVO> getProductCommentList(Long pId);
	
	// 댓글 생성 기능
	public void insert(ProductCommentVO vo);
	
	// 댓글 수정 기능
	public void update(ProductCommentVO vo);
	
	// 댓글 삭제 기능
	public void delete(Long pcId);
}
