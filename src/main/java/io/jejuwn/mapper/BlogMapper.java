package io.jejuwn.mapper;

import java.util.List;

import io.jejuwn.persistence.BlogVO;


public interface BlogMapper {
	
	public List<BlogVO> getBlogList();
	
	public void insertBlog(BlogVO vo);
}
