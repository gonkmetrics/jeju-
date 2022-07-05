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
<<<<<<< HEAD
	public List<ProductComment> getProductCommentList(Long productId){
=======
	public List<ProductComment> getProductCommentList(Long pId){
>>>>>>> origin/merge_prep
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
<<<<<<< HEAD
	public void deleteProdcutComment(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
=======
	public void deleteProdcutComment(Long pId) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(pId));
>>>>>>> origin/merge_prep
	}

}
