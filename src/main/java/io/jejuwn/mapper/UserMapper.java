package io.jejuwn.mapper;

import java.util.List;

import io.jejuwn.persistence.UserVO;

public interface UserMapper {
	
	public List<UserVO> getList();
	
	public void insert(UserVO vo);
	
	public void update(UserVO vo);
	
	public void delete(Long id);
	
	public UserVO userDetail(Long id);
}
