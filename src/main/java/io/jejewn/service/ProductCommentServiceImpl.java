package io.jejewn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.jejewn.mapper.ProductCommentMapper;
import io.jejewn.persistence.ProductCommentVO;

public class ProductCommentServiceImpl implements ProductCommentService {
	
	@Autowired
	private ProductCommentMapper mapper;
	
	@Override
	public List<ProductCommentVO> getProductCommentList(Long pId){
		return mapper.getProductCommentList(pId);
	}
	
	@Override
	public void insertProductComment(ProductCommentVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void updateProductComment(ProductCommentVO vo) {
		mapper.update(vo);
	}
	@Override
	public void deleteProdcutComment(Long pId) {
		mapper.delete(pId);
	}

}
