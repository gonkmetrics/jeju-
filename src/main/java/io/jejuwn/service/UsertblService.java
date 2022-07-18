package io.jejuwn.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import io.jejuwn.model.Usertbl;

public interface UsertblService {
	
	// 유저리스트 불러오는 기능
	public List<Usertbl> listUser();
	// 유저 회원가입
	public void insertUser(Usertbl vo);
	// 유저 회원탈퇴
	public void deleteUser(Long id);
	// 유저 상세정보
	public Usertbl userDetail(Long id);
	// 유저 회원정보수정
	public void updateUser(Usertbl vo);
	
	public Page<Usertbl> userList(int page);
}
