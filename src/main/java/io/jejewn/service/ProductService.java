package io.jejewn.service;

import io.jejewn.persistence.ProductVO;

public interface ProductService {

	public void insert(ProductVO vo);	
	public void delete(Long pId);	
	public void update(ProductVO vo);
	public void getDetail(Long pId);
	
	
}
