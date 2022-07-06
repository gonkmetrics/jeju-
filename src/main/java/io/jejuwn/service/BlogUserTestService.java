package io.jejuwn.service;

import java.util.List;

import io.jejuwn.model.BlogUserTest;


public interface BlogUserTestService {
	
	// 블로그 유저 리스트
	public List<BlogUserTest> getAllBlogUserList();
	
	// 블로그 유저 생성
	public void blogUserInsert(BlogUserTest vo);
	
	// 블로그 유저 삭제
	public void blogUserDelete(Long id);
	
	// 블로그 유저 수정
	public void blogUserUpdate(BlogUserTest vo);
	
	/* 블로그 유저 상세 보기
	public BlogUserTest blogUserDetail(Long id); */
	
	//blog create table
	public void blogCreate(Long id);

}
