package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.ProductComment;
import io.jejuwn.repository.ProductCommentRepository;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	
	@Autowired
	private ProductCommentRepository repository;
	
	@Override
	public List<ProductComment> getProductComment(Long productId){
		return repository.findAllById(null);
	}
	
	@Override
	public void insertProductComment(ProductComment vo) {
		repository.save(vo);
	}
	
	@Override
	public void updateProductComment(ProductComment vo) {
		repository.save(vo);
	}
	@Override
	public void deleteProdcutComment(Long id) {
		repository.deleteById(id);
	}

}
