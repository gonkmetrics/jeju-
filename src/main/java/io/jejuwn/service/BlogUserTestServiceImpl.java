package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.BlogUserTestMapper;
import io.jejuwn.model.BlogUserTest;

@Service
public class BlogUserTestServiceImpl implements BlogUserTestService {
	
	@Autowired
	private BlogUserTestMapper mapper;
	
	// 블로그 유저 리스트
	public List<BlogUserTest> getAllBlogUserList(){
		return mapper.selectByExample(null);
	}
	
	// 블로그 유저 생성
	public void blogUserInsert(BlogUserTest vo) {
		mapper.insert(vo);
	}
	
	// 블로그 유저 삭제
	public void blogUserDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	// 블로그 유저 수정
	public void blogUserUpdate(BlogUserTest vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	/* 블로그 유저 상세 보기
	public BlogUserTest blogUserDetail(Long id) {
		BlogUserTest blogUserDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
		return blogUserDetail;
	} */

}
