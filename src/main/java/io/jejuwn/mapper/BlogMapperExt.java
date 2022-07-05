package io.jejuwn.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapperExt {
	
	void createBlogTable (BigDecimal id);

}
