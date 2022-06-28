package io.jejewn.mapper;

import io.jejewn.persistence.ProductInfoVO;

public interface ProductInfoMapper {
	
	public void insert(ProductInfoVO vo);
	
	public void delete(Long piId);
}
