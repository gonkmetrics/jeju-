package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.BlogVO;


public interface BlogMapper {
	
	public List<BlogVO> getBlogList();
	
	public void insertBlog(BlogVO vo);
}
