package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Role;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;
import io.jejuwn.security.jwt.JwtTokenProvider;

public interface UsertblService {
	
	// 유저리스트 불러오는 기능
	public List<Usertbl> listUser(); //LIST
	// 유저 회원가입
	public void insertUser(Usertbl vo); //SAVE
	// 유저 회원탈퇴
	public void deleteUser(Long id);
	// 유저 상세정보
	public Usertbl userDetail(Long id); //GETUser
	// 유저 회원정보수정
	public void updateUser(Usertbl vo);
	
	//Spring Data methods:
	Usertbl saveUser(Usertbl user);
	Role saveRole(Role role);
	void grantRoleToUser(String username, String roleName);
	public UserDetails loginCheckUser(String nick);
	
	public Optional<Usertbl> findByIdPw(Long id);
	public Optional<Usertbl> findById(Long id);
	public Optional<Usertbl> findByNick(String nick);
	public Optional<Usertbl> findByIdAndPass(Long id, String pass);
	
}
