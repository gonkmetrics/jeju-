package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.ProductCommentMapper;
import io.jejuwn.model.ProductComment;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	
	@Autowired
	private ProductCommentMapper mapper;
	
	@Override
	public List<ProductComment> getProductCommentList(Long pId){
		return mapper.selectByExample(null);
	}
	
	@Override
	public void insertProductComment(ProductComment vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void updateProductComment(ProductComment vo) {
		mapper.updateByPrimaryKey(vo);
	}
	@Override
	public void deleteProdcutComment(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}

}
