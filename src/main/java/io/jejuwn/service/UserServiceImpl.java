package io.jejuwn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.UserMapper;
import io.jejuwn.persistence.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<UserVO> listUser() {
		return mapper.getList();
	}
	
	@Override
	public void insertUser(UserVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void deleteUser(Long id) {
		mapper.delete(id);
	}
	
	@Override
	public UserVO userDetail(Long id) {
		return mapper.userDetail(id);
	}
	
	public void updateUser(UserVO vo) {
		mapper.update(vo);
	}

}
