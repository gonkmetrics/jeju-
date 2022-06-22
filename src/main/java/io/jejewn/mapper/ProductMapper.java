package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.ProductVO;

public interface ProductMapper {
	

	public List<ProductVO> getList(Long pId);
	
	public void insert(ProductVO vo);
	
	public void delete(Long pId);
	
	public void update(ProductVO vo);
	
	public ProductVO getDetail(Long pId);
}
