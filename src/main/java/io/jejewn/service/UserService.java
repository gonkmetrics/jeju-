package io.jejewn.service;

import java.util.List;

import io.jejewn.persistence.UserVO;

public interface UserService {
	
	// 유저리스트 불러오는 기능
	public List<UserVO> listUser();
	// 유저 회원가입
	public void insertUser(UserVO vo);
	// 유저 회원탈퇴
	public void deleteUser(Long id);
	// 유저 상세정보
	public UserVO userDetail(Long id);
	// 유저 회원정보수정
	public void updateUser(UserVO vo);
}
