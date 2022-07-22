package io.jejuwn.mapper;

import org.apache.ibatis.annotations.Mapper;

import io.jejuwn.model.BlogUserTest;

@Mapper
public interface BlogExtMapper {
	void createBlogTable (int id);
	
	void insertBlog (BlogUserTest vo);
	
	void updateBlog (BlogUserTest vo);
	
	void deleteBlog (int id);
}
